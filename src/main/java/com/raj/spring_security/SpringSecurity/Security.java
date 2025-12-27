package com.raj.spring_security.SpringSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.raj.spring_security.Filter.JwtFilter;

@EnableWebSecurity
@Configuration
public class Security {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login","/register").permitAll()
            .anyRequest().authenticated()
        );
        //.formLogin(Customizer.withDefaults());
        http.
            httpBasic(Customizer.withDefaults());
        
        return http
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager authenticationProvider(AuthenticationConfiguration configuration) throws Exception{
        // DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        // daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return configuration.getAuthenticationManager();
    }

}
