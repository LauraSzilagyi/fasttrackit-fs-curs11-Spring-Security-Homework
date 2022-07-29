package ro.fasttrackit.curs11homework.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs11homework.entity.Director;
import ro.fasttrackit.curs11homework.entity.School;
import ro.fasttrackit.curs11homework.entity.Student;
import ro.fasttrackit.curs11homework.entity.Teacher;
import ro.fasttrackit.curs11homework.repository.DirectorRepository;
import ro.fasttrackit.curs11homework.repository.SchoolRepository;
import ro.fasttrackit.curs11homework.repository.StudentRepository;
import ro.fasttrackit.curs11homework.repository.TeacherRepository;

import java.util.List;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final SchoolRepository schoolRepository;
    private final DirectorRepository directorRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;


    @Override
    public void run(String... args) throws Exception {
        if (directorRepository.findAll().isEmpty()) {
            Director director = directorRepository.save(
                    new Director(randomUUID().toString(), "Director1", 52)
            );
            System.out.println(director);

            addSchools(director);
        }
    }

    private void addSchools(Director director) {
        if (schoolRepository.findAll().isEmpty()) {
            School school = schoolRepository.save(
                    new School(randomUUID().toString(), "Good School", director.id())
            );
            System.out.println(school);

            addStudentsToSchool(school);
            addTeachersToSchool(school);
        }
    }

    private void addStudentsToSchool(School school) {
        if (studentRepository.findAll().isEmpty()) {
            List<Student> students = studentRepository.saveAll(
                    List.of(
                            new Student(randomUUID().toString(), "student1", 12, school.id()),
                            new Student(randomUUID().toString(), "student2", 10, school.id()),
                            new Student(randomUUID().toString(), "student3", 11, school.id())
                    )
            );
            System.out.println(students);
        }
    }

    private void addTeachersToSchool(School school) {
        if (teacherRepository.findAll().isEmpty()) {
            List<Teacher> teachers = teacherRepository.saveAll(
                    List.of(
                            new Teacher(randomUUID().toString(), "teacher1", 45, true, null, school.id()),
                            new Teacher(randomUUID().toString(), "teacher2", 27, false, null, school.id()),
                            new Teacher(randomUUID().toString(), "teacher3", 60, true, null, school.id())
                    )
            );
            System.out.println(teachers);
        }
    }
}
