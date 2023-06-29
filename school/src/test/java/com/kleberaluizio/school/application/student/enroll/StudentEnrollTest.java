package com.kleberaluizio.school.application.student.enroll;

import com.kleberaluizio.school.domain.students.CPF;
import com.kleberaluizio.school.domain.students.Student;
import com.kleberaluizio.school.domain.students.StudentRepository;
import com.kleberaluizio.school.infra.students.StudentRepositoryInMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentEnrollTest {

    @Test
    void studentShouldBePersisted(){

        // I could use repository as a Mock using Mockito.
        StudentRepository repository = new StudentRepositoryInMemory();
        StudentEnroll useCase = new StudentEnroll(repository);

        StudentEnrollDTO data = new StudentEnrollDTO(
                "Fulano",
                "123.456.789-00",
                "fulano@email.com");
        useCase.execute(data);

        Student founded = repository.findByCpf(
                new CPF(data.cpf()));

        assertEquals("Fulano",founded.getName());
        assertEquals("123.456.789-00", founded.getCpf());
        assertEquals("fulano@email.com",founded.getEmail());



    }

}