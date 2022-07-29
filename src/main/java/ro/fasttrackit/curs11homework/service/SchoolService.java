package ro.fasttrackit.curs11homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11homework.entity.School;
import ro.fasttrackit.curs11homework.exceptions.EntityNotFoundException;
import ro.fasttrackit.curs11homework.repository.SchoolRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;

    public List<String> getSchoolInfo() {
        return repository.findAll().stream()
                .map(School::info)
                .toList();
    }

    public void getSchoolById(String id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("School not found with id %s".formatted(id)));
    }
}
