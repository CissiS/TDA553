import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    private Volvo240 myVolvo;

    @BeforeEach
    void setUp() {
        myVolvo = new Volvo240();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void speedFactor() {
        myVolvo.startEngine();
        // calculate expected SpeedFactor
        double expectedSpeedFactor = myVolvo.getEnginePower() * 0.01 * Volvo240.trimFactor;
        assertEquals(expectedSpeedFactor, myVolvo.speedFactor());
    }

    @Test
    void incrementSpeed() {
        double initialSpeed = myVolvo.getCurrentSpeed();
        double incrementAmount = 25;
        myVolvo.incrementSpeed(incrementAmount);
        // calculate expected speed manually then compare
        // Math.min ensures the calculated speed does not exceed the engine power limit
        // Therefore, here is the test that ensures currentSpeed [0, enginePower]
        double expectedNewSpeed = Math.min(initialSpeed + myVolvo.speedFactor() * incrementAmount, myVolvo.getEnginePower());
        double actualNewSpeed = myVolvo.getCurrentSpeed();
        assertEquals(expectedNewSpeed, actualNewSpeed);
    }

    @Test
    void decrementSpeed() {
        double initialSpeed = myVolvo.getCurrentSpeed();
        // calculate expected speed manually then compare
        double decreaseAmount = 25;
        myVolvo.decrementSpeed(decreaseAmount);
        double expectedNewSpeed = Math.max(initialSpeed - myVolvo.speedFactor() * decreaseAmount,0);
        double actualNewSpeed = myVolvo.getCurrentSpeed();
        assertEquals(expectedNewSpeed, actualNewSpeed);

    }
}