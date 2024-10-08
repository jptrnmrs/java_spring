package com.ch08.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // 로그인 설정
        http.formLogin(login -> login
                                .loginPage("/user/login")
                                .defaultSuccessUrl("/user/success")
                                .failureUrl("/user/login?success=100")
                                .usernameParameter("username")
                                .passwordParameter("password"));

        // 로그아웃 설정
        http.logout(logout -> logout
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login?success=101"));
        // 인가 설정
        http.authorizeHttpRequests(authorize ->authorize
                .requestMatchers("/").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
                .requestMatchers("/staff/**").hasAnyRole("ADMIN","MANAGER","STAFF")
                .anyRequest().permitAll());

        // 기타 보안 설정

        http.csrf(configure->configure.disable());


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
