// Assuming Volvo240 class is defined in the same package

public class Main {
    public static void main(String[] args) {
        Volvo240 myVolvo = new Volvo240(); // Create a Volvo240 object

        // Manipulate the Volvo240 object
        System.out.println("Initial speed: " + myVolvo.currentSpeed);
        myVolvo.gas(0.5); // Accelerate the car
        System.out.println("Speed after acceleration: " + myVolvo.currentSpeed);
        myVolvo.brake(0.3); // Decelerate the car
        System.out.println("Speed after braking: " + myVolvo.currentSpeed);
    }
}
