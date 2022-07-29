package ro.fasttrackit.curs11homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

//@Configuration
public class InMemoryUsersConfig {
    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        return new InMemoryUserDetailsManager(List.of(
                User.builder()
                        .username("student")
                        .password("student")
                        .roles("STUDENT")
                        .build(),
                User.builder()
                        .username("teacher")
                        .password("teacher")
                        .roles("TEACHER")
                        .build(),
                User.builder()
                        .username("director")
                        .password("director")
                        .roles("DIRECTOR")
                        .build()
        ));
    }
}
