package com.rajharit.patrimoine;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Person {
    private final String name;
    private final Patrimony patrimony;

    public Person(String name) {
        this.name = name;
        this.patrimony = new Patrimony();
    }

    public String getName() {
        return name;
    }

    public Patrimony getPatrimony() {
        return patrimony;
    }

    public String getPatrimonyReport(LocalDateTime currentDate) {
        return String.format("Rapport patrimonial de %s au %s:\n%s",
                name,
                currentDate,
                patrimony.getDetailedReport(LocalDateTime.parse(String.valueOf(currentDate))));
    }
}