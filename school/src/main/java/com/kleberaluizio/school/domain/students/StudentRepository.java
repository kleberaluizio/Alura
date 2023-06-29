package com.kleberaluizio.school.domain.students;

import java.util.List;

public interface StudentRepository {

    void enroll (Student student);
    Student findByCpf(CPF cpf);
    List<Student> enrolledStudents();

}
