package ro.fasttrackit.curs11homework.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder(toBuilder = true)
@Document(collection = "teachers")
public record Teacher(
        @Id
        String id,
        String name,
        Integer age,
        boolean discipline,
        List<String> evaluations,
        String schoolId
) {
}
