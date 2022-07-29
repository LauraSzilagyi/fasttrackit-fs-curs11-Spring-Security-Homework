package ro.fasttrackit.curs11homework.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11homework.entity.Teacher;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
