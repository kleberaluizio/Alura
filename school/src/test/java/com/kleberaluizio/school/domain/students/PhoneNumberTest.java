package com.kleberaluizio.school.domain.students;

import com.kleberaluizio.school.domain.students.PhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @Test
    void shouldNotCreatePhoneNumbersWithInvalidDDD(){
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber(null,"123456789"));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("","123456789"));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("1","123456789"));
    }

    @Test
    void shouldNotCreatePhoneNUmberWithInvalidNumber(){
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("40",null));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("40",""));
        assertThrows(IllegalArgumentException.class,
                ()-> new PhoneNumber("40","1"));
    }

    @Test
    void shouldCreateValidPhoneNumberAndDDD(){
        String ddd = "11";
        String number = "123456789";
        PhoneNumber phoneNumber = new PhoneNumber(ddd, number);
        assertEquals(ddd,phoneNumber.getDdd());
        assertEquals(number,phoneNumber.getNumber());
    }

}