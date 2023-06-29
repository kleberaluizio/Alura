package com.kleberaluizio.school.application.student.enroll;

import com.kleberaluizio.school.domain.students.*;

public class StudentEnroll {

    private final StudentRepository repository;

    public StudentEnroll(StudentRepository repository) {
        this.repository = repository;
    }

    // COMMAND
    public void execute(StudentEnrollDTO studentDTO){
        var newStudent = new Student(
                new CPF(studentDTO.cpf()),
                studentDTO.name(),
                new Email(studentDTO.email()));

        repository.enroll(newStudent);
    }
}
