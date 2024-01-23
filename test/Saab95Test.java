import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void setTurboOn() {
    }

    @org.junit.jupiter.api.Test
    void setTurboOff() {
    }

    @org.junit.jupiter.api.Test
    void speedFactor() {
        Saab95 mySaab = new Saab95();
        double initialSpeed = mySaab.getCurrentSpeed();
        mySaab.setTurboOn();
        double newSpeed = mySaab.getCurrentSpeed();
        assertEquals((initialSpeed)*1.3, newSpeed);
    }
    @org.junit.jupiter.api.Test
    public void testGasWithInvalidValues() {
        Saab95 mySaab = new Saab95();
        mySaab.startEngine();
        mySaab.gas(1.5);
        assertEquals(0.1, mySaab.getCurrentSpeed());

        mySaab.gas(-0.5);
        assertEquals(0.1, mySaab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
    }
}