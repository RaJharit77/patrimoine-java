package com.rajharit;

import com.rajharit.patrimoine.Flow;
import com.rajharit.patrimoine.Patrimony;
import com.rajharit.patrimoine.Person;
import com.rajharit.patrimoine.Money;
import com.rajharit.patrimoine.MaterialGoods;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person ilo = new Person("Ilo");

        Money cash = new Money("Espèces", LocalDate.parse("13/05/2024"), 400000);
        Money savings = new Money("Compte épargne",  LocalDate.parse("13/05/2024"), 200000);
        Money currentAccount = new Money("Compte courant",  LocalDate.parse("13/05/2024"), 600000);

        MaterialGoods computer = new MaterialGoods(
                "Ordinateur",  LocalDate.parse("26/10/2021"), 2000000, 0.1);
        MaterialGoods clothes = new MaterialGoods(
                "Vêtements", LocalDate.parse("01/01/2024"), 1000000, 0.2);

        Patrimony iloPatrimony = ilo.getPatrimony();
        iloPatrimony.addPossession(cash);
        iloPatrimony.addPossession(savings);
        iloPatrimony.addPossession(currentAccount);
        iloPatrimony.addPossession(computer);
        iloPatrimony.addPossession(clothes);

        Flow livingExpensesJune = new Flow("Train de vie juin", 500000, false);
        Flow livingExpensesJuly = new Flow("Train de vie juillet", 500000, false);
        currentAccount.addFlow(livingExpensesJune);
        currentAccount.addFlow(livingExpensesJuly);

        System.out.println(ilo.getPatrimonyReport(LocalDate.parse("26/06/2024").atStartOfDay()));
        System.out.println("\n----------------------------------\n");
        System.out.println(ilo.getPatrimonyReport(LocalDate.parse("14/07/2024").atStartOfDay()));

        System.out.println("\nSolde du compte courant le 14/07/2024: " +
                String.format("%.2f Ar", currentAccount.getAmount()));
    }
}