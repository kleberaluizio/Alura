package com.kleberaluizio.escola;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public void addPhoneNumber(String ddd, String number){
        this.phoneNumbers.add(new PhoneNumber(ddd, number));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
}
