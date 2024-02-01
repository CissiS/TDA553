import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    private Scania myscania;

    @BeforeEach
    void setUp() {
        myscania = new Scania();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
   void isRampPositioned() {
        assertTrue(myscania.isRampPositioned());
        // Höj rampen, inte är i position längre
        myscania.raise(10);
        assertFalse(myscania.isRampPositioned());
        // Sänk rampen tillbaka
        myscania.lower(10);
        assertTrue(myscania.isRampPositioned());

    }

}