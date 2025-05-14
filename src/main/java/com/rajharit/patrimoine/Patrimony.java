package com.rajharit.patrimoine;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente l'ensemble du patrimoine d'une personne
 */
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

    public double getTotalValue(LocalDate currentDate) {
        return possessions.stream()
                .mapToDouble(p -> p.getCurrentValue(currentDate))
                .sum();
    }

    public String getDetailedReport(LocalDate currentDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("Détail du patrimoine au ").append(currentDate).append(":\n");

        for (Possession p : possessions) {
            sb.append("- ").append(p)
                    .append(", valeur actuelle: ")
                    .append(String.format("%.2f Ar", p.getCurrentValue(currentDate)))
                    .append("\n");
        }

        sb.append("Valeur totale: ")
                .append(String.format("%.2f Ar", getTotalValue(currentDate)));

        return sb.toString();
    }
}