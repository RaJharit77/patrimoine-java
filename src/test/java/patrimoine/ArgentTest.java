package patrimoine;

import com.rajharit.patrimoine.Argent;
import com.rajharit.patrimoine.Devise;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArgentTest {
    @Test
    void testAdditionner() {
        Argent a1 = new Argent(100.0, Devise.ARIARY);
        Argent a2 = new Argent(200.0, Devise.ARIARY);
        Argent result = a1.additionner(a2);
        assertEquals(300.0, result.getMontant());
        assertEquals(Devise.ARIARY, result.getDevise());
    }

    @Test
    void testSoustraire() {
        Argent a1 = new Argent(500.0, Devise.ARIARY);
        Argent a2 = new Argent(300.0, Devise.ARIARY);
        Argent result = a1.soustraire(a2);
        assertEquals(200.0, result.getMontant());
    }

    @Test
    void testMultiplier() {
        Argent a = new Argent(100.0, Devise.ARIARY);
        Argent result = a.multiplier(2.5);
        assertEquals(250.0, result.getMontant());
    }

    @Test
    void testAriaryFactory() {
        Argent a = Argent.ariary(1000.0);
        assertEquals(1000.0, a.getMontant());
        assertEquals(Devise.ARIARY, a.getDevise());
    }
}
