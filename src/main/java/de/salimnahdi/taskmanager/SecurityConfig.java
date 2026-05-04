package de.salimnahdi.taskmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/delete-task/**", "/toggle-task/**", "/add-task/**").permitAll()
                        .anyRequest().authenticated()
                )
                // Disable CSRF for H2 AND from actions
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**", "/add-task/**"))
                // Fix for H2 Frames
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                // Enable default Login Form
                .formLogin(form -> form
                        .loginPage("/login") // Use our custom URL
                        .defaultSuccessUrl("/", true) // Go to the task list after login
                        .permitAll()
                );
        return http.build();
    }
}