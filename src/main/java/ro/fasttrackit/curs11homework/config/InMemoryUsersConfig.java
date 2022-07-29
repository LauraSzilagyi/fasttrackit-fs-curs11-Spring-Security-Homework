package ro.fasttrackit.curs11homework.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InMemoryUsersConfig {

    private final CredentialConfigurationReader credentialConfigurationReader;
    @Bean
    InMemoryUserDetailsManager userDetailsManager() {

        List<UserDetails> userDetails = credentialConfigurationReader.getUsers().stream()
                .map(user -> User.builder()
                        .username(user.user())
                        .password(user.password())
                        .roles(user.role().toUpperCase())
                        .build())
                .toList();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
