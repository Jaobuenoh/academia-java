package com.example.loja.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {


    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "", "/images/**", "", "").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("").permitAll()
                        .requestMatchers("").permitAll()
                        .requestMatchers("").permitAll()
                        .anyRequest().authenticated()
                );
        http
                .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/home")
                        .failureUrl("/login_error")
                        .permitAll()
                        .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/?logout")
                        .and()
                        .httpBasic();



        return http.build();
    }
}

// Tem que adaptar tudo isso aqui, além de melhorar a consistência do seu entendimento sobre essa classe e seus respoctivos códigos
