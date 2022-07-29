package ro.fasttrackit.curs11homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.*;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain httpSecurityConfig(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(
                        authz -> authz
                                .antMatchers("/me").authenticated()
                                .antMatchers("/school-info").permitAll()
                                .antMatchers(GET,"/students").authenticated()
                                .antMatchers(POST,"/students").hasAnyRole("TEACHER", "DIRECTOR")
                                .antMatchers("/teacher/{id}").hasRole("STUDENT")
                                .antMatchers( "/teacher").hasRole("DIRECTOR")
                                .anyRequest().denyAll()
                )
                .csrf().disable()
                .formLogin()
                .and()
                .httpBasic();
        return http.build();
    }
}
