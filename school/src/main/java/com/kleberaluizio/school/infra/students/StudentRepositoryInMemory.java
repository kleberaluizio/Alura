package com.kleberaluizio.school.infra.students;

import com.kleberaluizio.school.domain.students.CPF;
import com.kleberaluizio.school.domain.students.Student;
import com.kleberaluizio.school.domain.students.StudentNotFounded;
import com.kleberaluizio.school.domain.students.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {
    private List<Student> enrolled = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolled.add(student);
    }

    @Override
    public Student findByCpf(CPF cpf) {
//        for (Student student : enrolled) {
//            if(student.getCpf() == cpf.getCpfNumber()){
//                return student;
//            }
//        }
//        return null;

        return this.enrolled.stream()
                .filter(s -> s.getCpf().equals(cpf.getCpfNumber()))
                .findFirst()
                .orElseThrow(() -> new StudentNotFounded(cpf));
    }

    @Override
    public List<Student> enrolledStudents() {
        return enrolled;
    }
}
