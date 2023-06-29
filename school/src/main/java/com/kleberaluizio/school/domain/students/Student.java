package com.kleberaluizio.school.domain.students;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    private String password;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(String ddd, String number){
        this.phoneNumbers.add(new PhoneNumber(ddd, number));
    }

    public String getCpf() {
        return cpf.getCpfNumber();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getEmailAddress();
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
