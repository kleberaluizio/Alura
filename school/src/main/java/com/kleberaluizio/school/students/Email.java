package com.kleberaluizio.school.students;

public class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        if(emailAddress == null || !emailAddress.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email is not valid!");
        } else {
            this.emailAddress = emailAddress;
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
