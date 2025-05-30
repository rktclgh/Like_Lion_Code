package com.test01.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity // Spring Security 활성화
public class AuthorizationServerConfig {

    // 1. 보안 필터 체인 - DI로 jwtDecoder를 주입
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http, JwtDecoder jwtDecoder) throws Exception {
        http
            .securityMatcher("/oauth2/**") 
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() 
            )
            .exceptionHandling(exception ->
                exception.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")) 
            )
            .oauth2ResourceServer(oauth2ResourceServer ->
                oauth2ResourceServer.jwt(jwt ->
                    jwt.decoder(jwtDecoder) 
                )
            );

        return http.build();
    }

    // 2. RSA KeyPair를 생성하는 Bean
    @Bean
    public KeyPair keyPair() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            return generator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("RSA 알고리즘을 사용할 수 없습니다.", e);
        }
    }

    // 3. JwtDecoder Bean - KeyPair의 PublicKey를 사용
    @Bean
    public JwtDecoder jwtDecoder(KeyPair keyPair) {
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair.getPublic()).build();
    }

    // 4. 클라이언트 등록 정보 (메모리 기반)
    @Bean
    public InMemoryRegisteredClientRepository registeredClientRepository(PasswordEncoder passwordEncoder) {
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
            .clientId("client")
            .clientSecret(passwordEncoder.encode("secret"))
            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
            .scope("read")
            .build();

        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    //5.인증 서버 설정 (토큰 엔드포인트 지정)
    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder()
            .tokenEndpoint("/oauth2/token")
            .build();
    }
}
//curl -v -X POST "http://localhost:9000/oauth2/token" -H "Content-Type: application/x-www-form-urlencoded" -u client:secret -d "grant_type=client_credentials"
