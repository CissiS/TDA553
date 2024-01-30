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
    void gas() {
        myscania.gas(0.5);
        assertEquals(0.5*myscania.getEnginePower()*0.02, myscania.getCurrentSpeed());

        assertThrows(IllegalArgumentException.class, () -> myscania.raise(70));

        myscania.stopEngine();
        myscania.raise(70);
        assertEquals(70, myscania.getTrailerAngle());
    }

    @Test
    void raise() {
        myscania.raise(69);
        assertEquals(69, myscania.getTrailerAngle());

        myscania.raise(3);
        assertEquals(70, myscania.getTrailerAngle());

    }

    @Test
    void lower() {
        myscania.lower(69);
        assertEquals(0, myscania.getTrailerAngle());

        myscania.raise(70);
        myscania.lower(3);
        assertEquals(67, myscania.getTrailerAngle());
    }

}