package com.kleberaluizio;

import java.time.LocalDateTime;

public class StudentIndication {

    private Student indicated;
    private Student indicator;
    private LocalDateTime indicationData;

    public StudentIndication(Student indicated, Student indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.indicationData = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getIndicationData() {
        return indicationData;
    }
}
