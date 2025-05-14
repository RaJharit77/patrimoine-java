package com.rajharit;

import com.rajharit.patrimoine.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person ilo = new Person("Ilo");

        Money cash = new Money("Espèces", LocalDate.parse("2024-05-13"), 400000);
        Money savings = new Money("Compte épargne", LocalDate.parse("2024-05-13"), 200000);
        Money currentAccount = new Money("Compte courant", LocalDate.parse("2024-05-13"), 600000);

        MaterialGoods computer = new MaterialGoods(
                "Ordinateur", LocalDate.parse("2021-10-26"), 2000000, 0.1);
        MaterialGoods clothes = new MaterialGoods(
                "Vêtements", LocalDate.parse("2024-01-01"), 1000000, 0.2);

        Lifestyle lifestyle = new Lifestyle("Train de vie", 500000, LocalDate.parse("2024-06-01"));

        Patrimony iloPatrimony = ilo.getPatrimony();
        iloPatrimony.addPossession(cash);
        iloPatrimony.addPossession(savings);
        iloPatrimony.addPossession(currentAccount);
        iloPatrimony.addPossession(computer);
        iloPatrimony.addPossession(clothes);

        currentAccount.addFlow(lifestyle.createMonthlyFlow(LocalDate.parse("2024-06-01")));
        currentAccount.addFlow(lifestyle.createMonthlyFlow(LocalDate.parse("2024-07-01")));

        System.out.println(ilo.getPatrimonyReport(LocalDate.parse("2024-06-26")));
        System.out.println("\n----------------------------------\n");
        System.out.println(ilo.getPatrimonyReport(LocalDate.parse("2024-07-14")));

        System.out.println("\nSolde du compte courant le 14/07/2024: " +
                String.format("%.2f Ar", currentAccount.getAmount()));
    }
}