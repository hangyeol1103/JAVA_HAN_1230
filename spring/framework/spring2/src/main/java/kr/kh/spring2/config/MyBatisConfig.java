package kr.kh.spring2.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan(basePackages = "kr.kh.spring2.dao") // 다오 인터페이스 패키지 경로 설정
@PropertySource("classpath:config.properties")
public class MyBatisConfig {

	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
    // MySQL 데이터 소스 설정
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/community?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // MyBatis SQL 세션 팩토리 설정
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml")
        );
         // TypeAlias 적용
        sessionFactory.setTypeAliasesPackage("kr.kh.spring2.model.vo");  // 여기에 패키지 경로 지정
        return sessionFactory.getObject();
    }
}