package com.kleberaluizio;

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

}