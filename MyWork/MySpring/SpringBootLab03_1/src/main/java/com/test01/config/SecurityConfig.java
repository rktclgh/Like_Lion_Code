package com.test01.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        System.out.println("---------- filterChain ----------");
        // authenticated 규칙 / 로그인 권한 / 로그아웃 권한
        http.csrf(cref -> cref.disable()) // 세션 기반이 아닌 토큰 기반으로 진행을 하기 때문에 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index" , "/login" , "/register", "/h2-console/**")
                        .permitAll() // 인증 없이 허용하겠다.
                        .anyRequest().authenticated()) // 나머지 요청은 반드시 인정되어야 한다.
                .formLogin(login -> login.loginPage("/login") // 리다이렉트
                        .defaultSuccessUrl("/home", true).permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(); // 패스워드 전용 해쉬 코드 -> 비밀번호 암호화 하겠다.


    }
}
