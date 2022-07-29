package ro.fasttrackit.curs11homework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11homework.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
