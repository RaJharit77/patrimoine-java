package com.rajharit.patrimoine;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Représente une personne et son patrimoine
 */
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

    public String getPatrimonyReport(LocalDate currentDate) {
        return String.format("Rapport patrimonial de %s au %s:\n%s",
                name,
                currentDate,
                patrimony.getDetailedReport(currentDate));
    }
}