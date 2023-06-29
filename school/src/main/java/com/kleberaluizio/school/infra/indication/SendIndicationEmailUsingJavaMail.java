package com.kleberaluizio.school.infra.indication;

import com.kleberaluizio.school.application.indication.SendIndicationEmail;
import com.kleberaluizio.school.domain.students.Student;

public class SendIndicationEmailUsingJavaMail implements SendIndicationEmail {
    @Override
    public void sendTo(Student indicatedStudent) {
        //Implements Java Mail logic
    }
}
