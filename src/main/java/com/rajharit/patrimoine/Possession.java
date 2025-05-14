package com.rajharit.patrimoine;

import lombok.*;

import java.time.LocalDate;

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