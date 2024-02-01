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

    public abstract void incrementSpeed(double amount);

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




