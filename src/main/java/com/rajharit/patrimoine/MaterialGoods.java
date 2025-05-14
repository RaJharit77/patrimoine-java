package com.rajharit.patrimoine;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Représente un bien matériel qui se déprécie avec le temps
 */
@Getter
@Setter
@ToString
public class MaterialGoods extends Possession {
    private final double initialValue;
    private final double annualDepreciationRate;

    public MaterialGoods(String name, LocalDate acquisitionDate,
                         double initialValue, double annualDepreciationRate) {
        super(name, acquisitionDate);
        this.initialValue = initialValue;
        this.annualDepreciationRate = annualDepreciationRate;
    }

    @Override
    public double getCurrentValue(LocalDate currentDate) {
        if (currentDate.isBefore(getAcquisitionDate())) {
            return 0;
        }

        long fullYears = ChronoUnit.YEARS.between(getAcquisitionDate(), currentDate);
        LocalDate startOfCurrentYear = currentDate.withDayOfYear(1);
        long daysInCurrentYear = ChronoUnit.DAYS.between(startOfCurrentYear, currentDate) + 1;

        double depreciation = 0;
        double remainingValue = initialValue;

        for (int i = 0; i < fullYears; i++) {
            double yearlyDepreciation = remainingValue * annualDepreciationRate;
            depreciation += yearlyDepreciation;
            remainingValue -= yearlyDepreciation;
        }

        if (daysInCurrentYear > 0) {
            double currentYearDepreciation = remainingValue * annualDepreciationRate *
                    (daysInCurrentYear / 365.0);
            depreciation += currentYearDepreciation;
        }

        return Math.max(0, initialValue - depreciation);
    }
}