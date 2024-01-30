import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class CarTransportTest {
    private CarTransport carcarrier;
    private Volvo240 volvo240;
    private Saab95 saab95;

    @BeforeEach
    void setUp() {
        carcarrier = new CarTransport();
        volvo240 = new Volvo240();
        saab95 =new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void move() {
    }

    @Test
    void gas() {
    }

    @Test
    void incrementAngle() {
    }

    @Test
    void decrementAngle() {
    }

    @Test
    void raiseRamp() {
        // Kan vara värt att testa ramperna likt i Scania här med
    }

    @Test
    void lowerRamp() {
    }

    @Test
    void loadCar() {
        carcarrier.lowerRamp();
        assertDoesNotThrow(() -> carcarrier.loadCar(volvo240)); // Will throw an Exception if Ramp is not lowered
        assertEquals(1, carcarrier.cars.size()); // One car has been loaded
    }

    @Test
    void unloadCar() {
        carcarrier.lowerRamp();
        carcarrier.loadCar(volvo240);
        assertDoesNotThrow(carcarrier::unloadCar); // No Exception while unloading
        assertEquals(0, carcarrier.cars.size()); // No car on transport
    }
    @Test
    void maxLoadTest(){
        carcarrier.lowerRamp();
        for (int i = 0; i < CarTransport.maxLoad; i++) {
            carcarrier.loadCar(saab95);
        }

        // Try loading one more car
        Volvo240 extraCar = new Volvo240();
        assertThrows(IllegalStateException.class, () -> carcarrier.loadCar(extraCar));
    }
}