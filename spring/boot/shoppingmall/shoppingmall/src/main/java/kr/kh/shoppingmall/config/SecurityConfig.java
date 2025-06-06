package kr.kh.shoppingmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.kh.shoppingmall.model.vo.UserRole;
import kr.kh.shoppingmall.service.MemberDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	MemberDetailService memberDetailService;
	
	@Value("${spring.remember.me.key}")
	String rememberMekey;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf->csrf.disable()) //사이트를 공격하는 것을 방지하는 / 뭔가가 방해를 하는데 그걸 막아주는 코드
			.authorizeHttpRequests(
				requests->
					requests
						.requestMatchers("/admin/**")
						.hasAnyAuthority(UserRole.ADMIN.name()) //권한이 ADMIN인 회원
						//.hasAanyRole(UserRole.ADMIN.name()) //권한이 ROLE_ADMIN인 회원
						.anyRequest()
						.permitAll() //모든 사람이 접근할 수 있게 하는 코드
			) 
			.formLogin(form ->
				form
					.loginPage("/login") //요거 주석처리하면 시큐리티에서 제공하는 로그인페이지로 이동. 여기서 /login url과 맞는 컨트롤러에 mapping을 추가해줘야 됨.
					.permitAll() //해당 로그인 페이지에 모두 접근 가능
					.loginProcessingUrl("/loginPost") //로그인 동작을 어떠한 url통해 동작을 시작할 것인지. login.html의 action의 url과 맞춰야함.
					.defaultSuccessUrl("/") // 성공했을 때 url을 어디로 할 것인지.
			)
			//자동 로그인 처리
			.rememberMe(rm-> rm
				.userDetailsService(memberDetailService)//자동 로그인할 때 사용할 userDetailService를 추가
				.key(rememberMekey)//키가 변경되면 기존 토큰이 무효처리
				.rememberMeCookieName("LC")//쿠키 이름
				.tokenValiditySeconds(60 * 60 * 24 * 7)//유지 기간 : 7일
			)
			.logout(logout ->
				logout
					.logoutUrl("/logoutPost")
					.logoutSuccessUrl("/")
					.clearAuthentication(true)
					.invalidateHttpSession(true)
					.permitAll()
				
				);
		return http.build();
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
