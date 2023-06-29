package com.kleberaluizio.school;

import com.kleberaluizio.school.application.student.enroll.StudentEnroll;
import com.kleberaluizio.school.application.student.enroll.StudentEnrollDTO;
import com.kleberaluizio.school.infra.students.StudentRepositoryInMemory;

public class EnrollStudentCLI {
    public static void main(String[] args) {
        String name = "Fulano";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        StudentEnroll studentEnroll = new StudentEnroll( new StudentRepositoryInMemory());

        studentEnroll.execute(new StudentEnrollDTO(name,cpf,email));

    }
}
