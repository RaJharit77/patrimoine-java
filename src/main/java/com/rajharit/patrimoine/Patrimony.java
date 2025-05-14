package com.rajharit.patrimoine;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Patrimony {
    private final List<Possession> possessions;

    public Patrimony() {
        this.possessions = new ArrayList<>();
    }

    public void addPossession(Possession possession) {
        possessions.add(possession);
    }

    public double getTotalValue(String currentDate) {
        return possessions.stream()
                .mapToDouble(p -> p.getCurrentValue(LocalDate.from(LocalDateTime.parse(currentDate))))
                .sum();
    }

    public String getDetailedReport(LocalDateTime currentDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("Détail du patrimoine au ").append(currentDate).append(":\n");

        for (Possession p : possessions) {
            sb.append("- ").append(p)
                    .append(", valeur actuelle: ")
                    .append(String.format("%.2f Ar", p.getCurrentValue(LocalDate.from(LocalDateTime.parse(String.valueOf(currentDate))))))
                    .append("\n");
        }

        sb.append("Valeur totale: ")
                .append(String.format("%.2f Ar", getTotalValue(String.valueOf(LocalDateTime.parse(String.valueOf(currentDate))))));

        return sb.toString();
    }
}