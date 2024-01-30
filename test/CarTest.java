import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNrDoors() {
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void move() {
        Car myCar = new Volvo240();
        myCar.startEngine();
        myCar.gas(1);
        myCar.move();
        assertEquals(new Point(0,1), myCar.position);
    }

    @Test
    void turnLeft() {
        Car myCar = new Volvo240();
        double initialDirection = myCar.getCurrentDirection();
        myCar.turnLeft();
        double newDirection = myCar.getCurrentDirection();
        assertEquals((initialDirection + 90) % 360, newDirection);
    }

    @Test
    void turnRight() {
        Car myCar = new Volvo240();
        double initialDirection = myCar.getCurrentDirection();
        myCar.turnRight();
        double newDirection = myCar.getCurrentDirection();
        //turnRight involves decreasing the direction by 90 degrees and,
        //therefore + 360 to handle the transition below 0 degrees when comparing
        assertEquals((initialDirection - 90 + 360) % 360, newDirection);
    }

    @Test
    void gas() {
        //Test gas with invalid values
        Saab95 mySaab = new Saab95();
        mySaab.startEngine();

        try{
            mySaab.gas(1.5);
            fail("Expected IllegalArgumentException but no exception was thrown.");
        } catch (IllegalArgumentException e){
            // Verify correct exception
            assertEquals("Wrong gas input: ", e.getMessage());
            // Verify that the current speed remains
            assertEquals(0.1, mySaab.getCurrentSpeed());
        }
        try {
            mySaab.gas(-0.5);
            fail("Expected IllegalArgumentException but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong gas input: ", e.getMessage());
            assertEquals(0.1, mySaab.getCurrentSpeed());
        }
    }
    @Test
    void gasIncreasesSpeed() {
        Saab95 mySaab = new Saab95();
        mySaab.startEngine();
        double initialSpeed = mySaab.getCurrentSpeed();
        mySaab.gas(0.5);
        // Current speed should not be less than the initial speed
        assertTrue(mySaab.getCurrentSpeed() >= initialSpeed);
    }

    @Test
    void brake() {
        // Test brake with invalid values
        Saab95 mySaab = new Saab95();
        mySaab.startEngine();

        // Test for brake with value greater than 1.0
        try {
            mySaab.brake(1.5);
            fail("Expected IllegalArgumentException but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Verify correct exception
            assertEquals("Wrong brake input: ", e.getMessage());
            // Verify that the current speed remains
            assertEquals(0.1, mySaab.getCurrentSpeed());
        }
        // Test for brake with value less than 0.0
        try {
            mySaab.brake(-0.5);
            fail("Expected IllegalArgumentException but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong brake input: ", e.getMessage());
            assertEquals(0.1, mySaab.getCurrentSpeed());
        }
    }
    @Test
    void brakeDecreasesSpeed() {
        Saab95 mySaab = new Saab95();
        mySaab.startEngine();
        mySaab.gas(0.5);
        double initialSpeed = mySaab.getCurrentSpeed();
        mySaab.brake(0.3);
        // Current speed should be less than the initial speed before brake
        assertTrue(mySaab.getCurrentSpeed() <= initialSpeed);
    }
}