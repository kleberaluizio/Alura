package com.kleberaluizio;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;

    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public void addPhoneNumber(String ddd, String number){
        this.phoneNumbers.add(new PhoneNumber(ddd, number));
    }

}
