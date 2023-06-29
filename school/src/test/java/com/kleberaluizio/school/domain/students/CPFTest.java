package com.kleberaluizio.school.domain.students;

import com.kleberaluizio.school.domain.students.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    void shouldNotCreateCpfWithInvalidNumbers(){
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(null));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF(""));
        assertThrows(IllegalArgumentException.class,
                () -> new CPF("invalidNumber"));
    }

    @Test
    void shouldAllowedCreateCpfWithValidNumber(){
        String number = "123.456.789-00";
        CPF cpf = new CPF(number);
        assertEquals(number, cpf.getCpfNumber());
    }
}