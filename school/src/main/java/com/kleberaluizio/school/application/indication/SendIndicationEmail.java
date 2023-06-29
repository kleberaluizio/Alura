package com.kleberaluizio.school.application.indication;

import com.kleberaluizio.school.domain.students.Student;

public interface SendIndicationEmail {

    void sendTo(Student indicatedStudent);
}
