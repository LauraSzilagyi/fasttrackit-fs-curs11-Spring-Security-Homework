package ro.fasttrackit.curs11homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11homework.entity.Teacher;
import ro.fasttrackit.curs11homework.exceptions.BadRequestException;
import ro.fasttrackit.curs11homework.exceptions.EntityNotFoundException;
import ro.fasttrackit.curs11homework.model.EvaluationModel;
import ro.fasttrackit.curs11homework.model.TeacherModel;
import ro.fasttrackit.curs11homework.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;
import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;
    private final SchoolService schoolService;

    public Teacher addEvaluationToTeacher(String id, EvaluationModel evaluation) {
        validateEvaluationModel(evaluation);
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id %s".formatted(id)));

        List<String> evaluations = ofNullable(teacher.evaluations()).orElse(new ArrayList<>());
        evaluations.add(evaluation.evaluation());
        Teacher newTeacher = teacher.toBuilder().evaluations(evaluations).build();
        repository.save(newTeacher);
        return newTeacher;
    }

    private void validateEvaluationModel(EvaluationModel evaluation) {
        if (isNull(evaluation)) {
            throw new BadRequestException("Evaluation can't be null!");
        }
    }

    public Teacher addTeacher(TeacherModel model) {
        validateModel(model);
        Teacher teacher = Teacher.builder()
                .id(randomUUID().toString())
                .age(model.age())
                .name(model.name())
                .schoolId(model.schoolId())
                .evaluations(null)
                .discipline(model.discipline())
                .build();

        return repository.save(teacher);

    }

    private void validateModel(TeacherModel model) {
        schoolService.getSchoolById(model.schoolId());
        if (isNull(model.name()) || isNull(model.age())) {
            throw new BadRequestException("Name and age can't be null!");
        }
    }
}
