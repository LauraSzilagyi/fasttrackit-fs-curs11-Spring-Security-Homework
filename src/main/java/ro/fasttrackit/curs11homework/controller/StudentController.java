package ro.fasttrackit.curs11homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs11homework.entity.Student;
import ro.fasttrackit.curs11homework.model.StudentModel;
import ro.fasttrackit.curs11homework.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    List<Student> getAllStudents() {
        return service.getAll();
    }

    @PostMapping
    Student addStudent(@RequestBody StudentModel model) {
        return service.addStudent(model);
    }


}
