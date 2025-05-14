package com.rajharit.patrimoine;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une somme d'argent (espèces, compte bancaire, etc.)
 */
@Getter
@Setter
@ToString
public class Money extends Possession {
    private double amount;
    private final List<Flow> flows;

    public Money(String name, LocalDate acquisitionDate, double initialAmount) {
        super(name, acquisitionDate);
        this.amount = initialAmount;
        this.flows = new ArrayList<>();
    }

    public void addFlow(Flow flow) {
        flows.add(flow);
        if (flow.isIncome()) {
            amount += flow.getAmount();
        } else {
            amount -= flow.getAmount();
        }
    }

    @Override
    public double getCurrentValue(LocalDate currentDate) {
        return amount;
    }
}