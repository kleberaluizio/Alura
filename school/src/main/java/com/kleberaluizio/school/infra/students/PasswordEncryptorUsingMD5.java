package com.kleberaluizio.school.infra.students;

import com.kleberaluizio.school.domain.students.PasswordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptorUsingMD5 implements PasswordEncryption {
    @Override
    public String encryptPassword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i =0; i< bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(i));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Error, not able generate password hash.");
        }
    }

    @Override
    public boolean passwordValidation(String encryptPassword, String password) {
        return encryptPassword.equals(encryptPassword(password));
    }
}
