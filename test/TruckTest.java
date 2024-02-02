import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    private Truck myscania;
    @BeforeEach
    void setUp() {
        myscania = new Scania() {
        };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void gas() {
        myscania.gas(0.5);
        assertEquals(0.5*myscania.getEnginePower()*0.02, myscania.getCurrentSpeed());

        //Bilen ska inte kunna köra nära rampen inte är i rätt position
        assertThrows(IllegalArgumentException.class, () -> myscania.raise(10));
    }

    @Test
    void raise() {
        // System.out.println("Rampvinkel: " + truck.getRampAngle());
        // System.out.println("Hastighet: " + truck.getCurrentSpeed());
        myscania.raise(69);
        assertEquals(69, myscania.getRampAngle());
        // System.out.println("Rampvinkel: " + myscania.getRampAngle());
        // System.out.println("Hastighet: " + myscania.getCurrentSpeed());

        assertThrows(IllegalArgumentException.class, ()->myscania.raise(3));

        // Check that ramp can't rise when car is moving
        // We expect that an Exception occurs when we try to rise the ramp while moving
        assertThrows(IllegalArgumentException.class, () -> myscania.gas(1));

    }

    @Test
    void lower() {
        myscania.lower(69);
        assertEquals(0, myscania.getRampAngle());

        myscania.raise(70);
        myscania.lower(3);
        assertEquals(67,myscania.getRampAngle());
    }

    @Test
    void speedFactor() {
    }

    @Test
    void getRampAngle() {
    }

    @Test
    void getNrDoors() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void getMaxRampAngle() {
    }

    @Test
    void getMinRampAngle() {
    }
}