import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Volvo240 myVolvo = new Volvo240();
        double initialDirection = myVolvo.getCurrentDirection();
        myVolvo.turnLeft();
        double newDirection = myVolvo.getCurrentDirection();
        assertEquals((initialDirection + 90) % 360, newDirection);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Volvo240 myVolvo = new Volvo240();
        double initialDirection = myVolvo.getCurrentDirection();
        myVolvo.turnRight();
        double newDirection = myVolvo.getCurrentDirection();
        assertEquals((initialDirection - 90) % 360, newDirection);
    }

    @org.junit.jupiter.api.Test     //onödig?? kollar så att en uträkning = en uträkning
    void speedFactor() {
        Volvo240 myVolvo = new Volvo240();      //testar den fysiska uträkningen med speedFactor funktionen
        myVolvo.startEngine();
        double expectedSpeedFactor = myVolvo.getEnginePower() * 0.01 * Volvo240.trimFactor;
        assertEquals(expectedSpeedFactor, myVolvo.speedFactor());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        Volvo240 myVolvo = new Volvo240();      //testar den fysiska uträkningen med speedFactor funktionen
        double initialSpeed = myVolvo.getCurrentSpeed();        //increment speed korrekt jämfört med fysisk uträkning
        double incrementAmount = 25;
        myVolvo.incrementSpeed(incrementAmount);
        double expectedNewSpeed = Math.min(initialSpeed + myVolvo.speedFactor() * incrementAmount, myVolvo.getEnginePower());
        double actualNewSpeed = myVolvo.getCurrentSpeed();
        assertEquals(expectedNewSpeed, actualNewSpeed);
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        Volvo240 myVolvo = new Volvo240();      //testar den fysiska uträkningen med speedFactor funktionen
        double initialSpeed = myVolvo.getCurrentSpeed();        //increment speed korrekt jämfört med fysisk uträkning
        double decreaseAmount = 25;
        myVolvo.decrementSpeed(decreaseAmount);
        double expectedNewSpeed = Math.max(initialSpeed - myVolvo.speedFactor() * decreaseAmount,0);
        double actualNewSpeed = myVolvo.getCurrentSpeed();
        assertEquals(expectedNewSpeed, actualNewSpeed);
    }
}