package com.kleberaluizio.escola;

import com.kleberaluizio.escola.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotCreateInvalidEmail(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Email("invalidEmail"));
    }

    @Test
    void shouldCreateValidEmail(){
        String emailAddress = "fulano@alura.com.br";
        Email email = new Email(emailAddress);
        assertEquals(emailAddress,email.getEmailAddress());
    }

}