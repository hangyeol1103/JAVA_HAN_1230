package kr.kh.shoppingmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
			requests->
				requests
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
