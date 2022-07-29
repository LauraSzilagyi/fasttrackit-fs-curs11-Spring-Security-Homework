package ro.fasttrackit.curs11homework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11homework.entity.Director;

public interface DirectorRepository extends MongoRepository<Director, String> {
}
