package patrimoine;

import com.rajharit.patrimoine.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CompteTest {
    @Test
    void testProjectionFuture() {
        Compte compte = new Compte("Compte courant",
                LocalDate.of(2024, 1, 1),
                new Argent(1000.0, Devise.ARIARY));

        Possession future = compte.projectionFuture(LocalDate.of(2025, 1, 1));

        assertEquals(1000.0, future.getValeur().getMontant());
        assertEquals("Compte courant", future.getNom());
    }

    @Test
    void testProjectionBeforeCreation() {
        Compte compte = new Compte("Compte",
                LocalDate.of(2024, 1, 1),
                new Argent(1000.0, Devise.ARIARY));

        Possession future = compte.projectionFuture(LocalDate.of(2023, 1, 1));

        assertEquals(0.0, future.getValeur().getMontant());
    }
}