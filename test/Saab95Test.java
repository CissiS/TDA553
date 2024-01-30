import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    private Saab95 mySaab;

    @BeforeEach
    void setUp() {
        mySaab = new Saab95();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void speedFactor() {
        mySaab.setTurboOn();
        // calculate expected SpeedFactor with TurboOn
        double expectedSpeedFactor = mySaab.getEnginePower() * 0.01 * 1.3;
        double actualSpeedFactor = mySaab.speedFactor();
        assertEquals(expectedSpeedFactor, actualSpeedFactor);
    }

    @Test
    void incrementSpeed() {
        double initialSpeed = mySaab.getCurrentSpeed();
        double incrementAmount = 25;
        mySaab.incrementSpeed(incrementAmount);
        // calculate expected speed manually then compare
        // Math.min ensures the calculated speed does not exceed the engine power limit
        // Therefore, here is the test that ensures currentSpeed [0, enginePower]
        double expectedNewSpeed = Math.min(initialSpeed + mySaab.speedFactor() * incrementAmount, mySaab.getEnginePower());
        double actualNewSpeed = mySaab.getCurrentSpeed();
        assertEquals(expectedNewSpeed, actualNewSpeed);
    }

    @Test
    void decrementSpeed() {
        double initialSpeed = mySaab.getCurrentSpeed();
        double decreaseAmount = 25;
        mySaab.decrementSpeed(decreaseAmount);
        // Math.max ensures the calculated speed does not go below 0
        double expectedNewSpeed = Math.max(initialSpeed - mySaab.speedFactor() * decreaseAmount, 0);
        double actualNewSpeed = mySaab.getCurrentSpeed();
        assertEquals(expectedNewSpeed, actualNewSpeed);
    }

    @Test
    void setTurboOn() {
        //To compare speed with turbo on vs off
        mySaab.setTurboOff();
        // Increase speed without turbo
        double speedWithoutTurbo = mySaab.getCurrentSpeed();
        //System.out.println("Speed at start: " + mySaab.getCurrentSpeed());
        mySaab.incrementSpeed(50);
        // System.out.println("Speed without Turbo: " + mySaab.getCurrentSpeed());

        // Turbo ON
        mySaab.setTurboOn();

        // Increase speed with turbo
        double speedWithTurbo = mySaab.getCurrentSpeed();
        mySaab.incrementSpeed(50);
        //System.out.println("Speed with Turbo: " + mySaab.getCurrentSpeed());

        // Compare speed with and without turbo
        assertTrue(speedWithTurbo < mySaab.getCurrentSpeed());
        assertTrue(speedWithoutTurbo < mySaab.getCurrentSpeed());
    }


    @Test
    void setTurboOff() {
        }
}