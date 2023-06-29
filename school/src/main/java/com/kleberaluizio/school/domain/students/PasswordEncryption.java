package com.kleberaluizio.school.domain.students;

public interface PasswordEncryption {

    String encryptPassword(String password);
    boolean passwordValidation(String encryptPassword, String password);

}
