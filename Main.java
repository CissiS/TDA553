import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        Volvo240 myVolvo = new Volvo240(); // Create a Volvo240 object

        // Print initial state
        System.out.println("Initial state:");
        System.out.println("Speed: " + myVolvo.getCurrentSpeed());
        System.out.println("Position: " + myVolvo.position);

        // Accelerate the car
        myVolvo.gas(1); // Full gas
        myVolvo.move(); // Move the car based on the current speed
        System.out.println("\nAfter acceleration and move:");
        System.out.println("Speed: " + myVolvo.getCurrentSpeed());
        System.out.println("Position: " + myVolvo.position);

        // Turn the car and move again
        myVolvo.turnLeft(); // Change direction
        myVolvo.move(); // Move the car based on the current speed and new direction
        System.out.println("\nAfter turning left and another move:");
        System.out.println("Speed: " + myVolvo.getCurrentSpeed());
        System.out.println("Position: " + myVolvo.position);

        // Decelerate the car
        myVolvo.brake(0.5); // Apply the brake
        myVolvo.move(); // Move the car based on the current speed
        System.out.println("\nAfter braking and move:");
        System.out.println("Speed: " + myVolvo.getCurrentSpeed());
        System.out.println("Position: " + myVolvo.position);
    }
}