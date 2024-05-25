package com.example.ifclubserver.common.config;

import com.example.ifclubserver.common.auth.CustomUserDetailsService;
import java.util.Arrays;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final static String MEMBER = "USER"; // Spring 기본 유저
  private final static String ADMIN = "ADMIN"; // Spring 기본 관리자

  @Bean
  public WebSecurityCustomizer configure() {
    return (web) -> web.ignoring()
        .requestMatchers(new AntPathRequestMatcher("/static/**"));
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return
        http.cors(cors -> cors
                .configurationSource(corsConfigurationSource()))

            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)

            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(
                    "/", // 기본화면
                    "/api/members/**", //FIXME : 일단 Member API 전체 열어둠
                    "/api/signup", // 회원가입
                    "/api/login", // 로그인
                    "/docs/**", // Swagger
                    "/v3/api-docs/**", // Swagger
                    "/api/token" //TODO: Access Token 재발급 (미구현)
                ).permitAll()
                .requestMatchers(HttpMethod.GET, "/api/my-page").hasAuthority(MEMBER) //FIXME: 예시 API
                .anyRequest().authenticated()
            )

            // 폼 로그인 (현재사용안함)
//        .formLogin(formLogin -> formLogin
//            .loginPage("/login")
//            .defaultSuccessUrl("/home")
//        )

            .logout(logout -> logout
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .addFilterBefore(new TokenAuthenticationFilter(jwtUtil),
//                UsernamePasswordAuthenticationFilter.class) //TODO: JWT 미구현
            .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http,
      BCryptPasswordEncoder bCryptPasswordEncoder,
      CustomUserDetailsService customUserDetailsService) throws Exception {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(customUserDetailsService);
    authProvider.setPasswordEncoder(bCryptPasswordEncoder);
    return new ProviderManager(authProvider);
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOriginPatterns(
        Arrays.asList(
            "http://localhost:3000",
            "http://localhost:3002",
            "http://localhost:8080",
            "http://220.85.169.165:8084",
            "http://220.85.169.165:3002"
        ));
    configuration.setAllowedMethods(
        Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
    configuration.setAllowCredentials(true);
    configuration.setAllowedHeaders(Collections.singletonList("*"));
    configuration.setMaxAge(3600L);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}