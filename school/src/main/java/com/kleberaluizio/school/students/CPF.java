package com.kleberaluizio.school.students;

public class CPF {

    private String cpfNumber;

    public CPF(String cpfNumber) {

        if(cpfNumber == null || !cpfNumber.matches("/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/")){
            throw  new IllegalArgumentException("CPF not valid!");
        } else {
            this.cpfNumber = cpfNumber;
        }
    }

    public String getCpfNumber() {
        return cpfNumber;
    }
}
