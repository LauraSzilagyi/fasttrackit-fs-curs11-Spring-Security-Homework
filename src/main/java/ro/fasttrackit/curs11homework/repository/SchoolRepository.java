package ro.fasttrackit.curs11homework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11homework.entity.School;

public interface SchoolRepository extends MongoRepository<School, String> {
}
