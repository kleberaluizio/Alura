package com.kleberaluizio.school.domain.students;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCpfAndEmail(String nome, String cpf, String email){
        this.student = new Student(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public StudentFactory withPhoneNumber(String ddd, String number){
        this.student.addPhoneNumber(ddd, number);
        return this;
    }

    public Student create(){
        return this.student;
    }

    public static void main(String[] args) {
        StudentFactory factory = new StudentFactory();
        Student student = factory
                .withNameCpfAndEmail("Kleber","123456789","kleber@gmail.com")
                .withPhoneNumber("55","123456789")
                .create();

    }
}
