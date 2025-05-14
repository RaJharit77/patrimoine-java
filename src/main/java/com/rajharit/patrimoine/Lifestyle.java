package com.rajharit.patrimoine;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Représente le train de vie d'une personne (dépenses régulières)
 */
@Getter
@Setter
@ToString
public class Lifestyle {
    private final String name;
    private final double monthlyExpense;
    private final LocalDate startDate;

    public Lifestyle(String name, double monthlyExpense, LocalDate startDate) {
        this.name = name;
        this.monthlyExpense = monthlyExpense;
        this.startDate = startDate;
    }

    public Flow createMonthlyFlow(LocalDate date) {
        return new Flow(name + " " + date.getMonth(), monthlyExpense, false);
    }
}
