package ro.fasttrackit.curs11homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs11homework.entity.Teacher;
import ro.fasttrackit.curs11homework.model.EvaluationModel;
import ro.fasttrackit.curs11homework.model.TeacherModel;
import ro.fasttrackit.curs11homework.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @PostMapping("{id}")
    Teacher addEvaluationToTeacher(@PathVariable String id, @RequestBody EvaluationModel evaluation) {
        return service.addEvaluationToTeacher(id, evaluation);
    }

    @PostMapping
    Teacher addTeacher(@RequestBody TeacherModel model) {
        return service.addTeacher(model);
    }

}
