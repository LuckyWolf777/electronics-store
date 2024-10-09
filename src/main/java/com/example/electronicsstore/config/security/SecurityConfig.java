package com.example.electronicsstore.config.security;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final DataSource dataSource;
    @Bean
    public JdbcUserDetailsManager user(PasswordEncoder encoder) {
//        UserDetails admin = User.builder()
//                .username("Alina")
//                .password(encoder.encode("1234"))
//                .roles("USER")
//                .authorities("USER")
//                .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorize) -> authorize.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                                .requestMatchers("/product/**").hasAuthority("ADMIN")
                                .requestMatchers("/product/show").permitAll()
                                .requestMatchers("/product/**").hasAuthority("ADMIN")
                                .requestMatchers("/product/get-id/").hasAuthority("USER")
                                .requestMatchers("/product/get-p1").hasAuthority("USER")
                                .requestMatchers("/product/temp").hasAuthority("USER")
                                .requestMatchers("/web/temp").permitAll()
                                .requestMatchers("/web/**").hasAuthority("ADMIN")
                                .requestMatchers("web/show-id/").hasAuthority("USER")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}

