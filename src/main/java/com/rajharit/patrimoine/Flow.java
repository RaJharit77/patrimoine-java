package com.rajharit.patrimoine;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Représente un flux financier (entrée ou sortie d'argent)
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Flow {
    private final String description;
    private final double amount;
    private final boolean isIncome;

    public Flow(String description, double amount, boolean isIncome) {
        this.description = description;
        this.amount = amount;
        this.isIncome = isIncome;
    }

    public boolean isIncome() {
        return isIncome;
    }
}