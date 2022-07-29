package ro.fasttrackit.curs11homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs11homework.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("school-info")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @GetMapping
    List<String> getSchoolInfo() {
        return service.getSchoolInfo();
    }

}
