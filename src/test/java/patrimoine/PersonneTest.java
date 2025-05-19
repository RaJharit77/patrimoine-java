package patrimoine;

import com.rajharit.patrimoine.Personne;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonneTest {

    @Test
    void testPersonneRecord() {
        Personne p = new Personne("John Doe");
        assertEquals("John Doe", p.nom());
    }
}