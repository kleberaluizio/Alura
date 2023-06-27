package com.kleberaluizio.escola;

public class PhoneNumber {

    private String ddd;
    private String number;

    public PhoneNumber(String ddd, String number) {

        if(ddd == null || number == null){
            throw new IllegalArgumentException("DDD and number cannot be null");
        }
        if(!ddd.matches("^\\d{3}")){
            throw new IllegalArgumentException("ddd not valid!");
        }
        if(!number.matches("^\\d{8,9}")){
            throw new IllegalArgumentException("number not valid!");
        }
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumber() {
        return number;
    }
}

