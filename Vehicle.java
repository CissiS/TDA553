import java.awt.*;
public abstract class Vehicle implements Movable {
    //Common attributes
    private final double enginePower;
    protected double currentSpeed;
    private Color color;
    protected String modelName;
    protected Point position;
    private double currentDirection;
    private final int length;


    public Vehicle(double enginePower, Color color, String modelName, int length) {
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point(0, 0);
        this.currentDirection = 90;
        this.length = length;
        stopEngine();
    }

    private void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }

    public void setCurrentSpeed(double currentSpeed){
        if (currentSpeed >= 0 && currentSpeed <= enginePower) {
            this.currentSpeed = currentSpeed;
            // Speed can't be negative
        } else if (currentSpeed < 0) {
            this.currentSpeed = 0;
            // Speed can't be higher than enginePower
        } else if (currentSpeed > enginePower){
            this.currentSpeed = enginePower;
        }
    } ;

    public abstract void decrementSpeed(double amount);

    protected abstract double speedFactor();

    public void move() {
        double deltaX = currentSpeed * Math.cos(Math.toRadians(currentDirection));
        double deltaY = currentSpeed * Math.sin(Math.toRadians(currentDirection));

        position.x += (int) deltaX;
        position.y += (int) deltaY;
    }

    public void turnLeft() {
        //Turn Upwards
        currentDirection += 90;
        if (currentDirection >= 360) {
            currentDirection -= 360;
        }
    }

    public void turnRight() {
        //Turn Downwards
        currentDirection -= 90;
        if (currentDirection < 0) {
            currentDirection += 360;
        }

    }

    protected double getCurrentDirection() {
        return currentDirection;
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Wrong gas input: ");
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Wrong brake input: ");
        }
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public int getlength() {
        return length;
    }
}





