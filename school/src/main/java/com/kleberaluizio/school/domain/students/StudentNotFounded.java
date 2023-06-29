package com.kleberaluizio.school.domain.students;

public class StudentNotFounded extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    public StudentNotFounded(CPF cpf){
        super("Student with CPF: " + cpf.getCpfNumber() + " was not founded!");
    }
}
