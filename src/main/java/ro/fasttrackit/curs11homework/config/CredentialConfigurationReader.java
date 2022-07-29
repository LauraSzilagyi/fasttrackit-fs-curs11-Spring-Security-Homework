package ro.fasttrackit.curs11homework.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.security")
public class CredentialConfigurationReader {

    private final List<User> users = new ArrayList<>();

    public void setConfig(List<User> users) {
       this.users.addAll(users);
    }
}

record User(String user, String password, String role) {}
