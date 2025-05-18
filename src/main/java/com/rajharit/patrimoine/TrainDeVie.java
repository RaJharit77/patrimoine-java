package com.rajharit.patrimoine;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;

import static com.rajharit.patrimoine.Argent.ariary;
import static java.time.temporal.ChronoUnit.MONTHS;

@Getter
public final class TrainDeVie extends Possession {
    private final Compte financeur;
    private final int jourDOperation;
    private final LocalDate debutDeLaPonction;

    public TrainDeVie(String nom, LocalDate aDateDe, Argent valeur, Compte financeur, int jourDOperation, LocalDate debutDeLaPonction) {
        super(nom, aDateDe, valeur);
        this.financeur = financeur;
        this.jourDOperation = jourDOperation;
        this.debutDeLaPonction = debutDeLaPonction;
    }

    @Override
    public TrainDeVie projectionFuture(LocalDate dateFuture) {
        if (dateFuture.isBefore(debutDeLaPonction)) {
            return new TrainDeVie(
                    nom,
                    dateFuture,
                    ariary(0d),
                    financeur,
                    jourDOperation,
                    debutDeLaPonction
            );
        }

        long moisEcoulee = MONTHS.between(debutDeLaPonction, dateFuture);

        if (dateFuture.getDayOfMonth() >= jourDOperation) {
            Argent valeurFuture = financeur.getValeur()
                    .soustraire(valeur.multiplier(moisEcoulee));
        }
        return null;
    }
}