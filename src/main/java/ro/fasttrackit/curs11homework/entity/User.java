package ro.fasttrackit.curs11homework.entity;

import lombok.Builder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document("users")
@Builder
public record User(
        @Id
        String userId,
        @Indexed(unique = true)
        String username,
        String password,
        List<String> roles
) {
}
