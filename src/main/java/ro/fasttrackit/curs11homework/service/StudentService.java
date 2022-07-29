package ro.fasttrackit.curs11homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11homework.entity.Student;
import ro.fasttrackit.curs11homework.entity.User;
import ro.fasttrackit.curs11homework.exceptions.BadRequestException;
import ro.fasttrackit.curs11homework.model.StudentModel;
import ro.fasttrackit.curs11homework.repository.StudentRepository;
import ro.fasttrackit.curs11homework.repository.UserRepository;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final SchoolService schoolService;
    private final UserRepository userRepository;


    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student addStudent(StudentModel model) {
        validateModel(model);
        Student entity = Student.builder()
                .id(randomUUID().toString())
                .age(model.age())
                .name(model.name())
                .schoolId(model.schoolId())
                .build();
        Student student = repository.save(entity);
        createUserForStudent(student);
        return student;
    }

    private void createUserForStudent(Student student) {
        User user = User.builder()
                .userId(student.id())
                .username(student.name().substring(0, 4))
                .password(student.name())
                .roles(List.of("ROLE_STUDENT"))
                .build();
        userRepository.save(user);
    }

    private void validateModel(StudentModel model) {
        schoolService.getSchoolById(model.schoolId());
        if (isNull(model.name()) || isNull(model.age())) {
            throw new BadRequestException("Must contains name and age!");
        }
    }
}
