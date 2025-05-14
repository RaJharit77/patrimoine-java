package com.rajharit.patrimoine;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Classe abstraite représentant une possession quelconque dans le patrimoine
 */
@Getter
@Setter
@ToString
public abstract class Possession {
    private final String name;
    private final LocalDate acquisitionDate;

    public Possession(String name, LocalDate acquisitionDate) {
        this.name = name;
        this.acquisitionDate = acquisitionDate;
    }

    public abstract double getCurrentValue(LocalDate currentDate);
}