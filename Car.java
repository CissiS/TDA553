import java.awt.*;
public abstract class Car implements Movable {
    //Common attributes
    private final int nrDoors;
    private final double enginePower;
    protected double currentSpeed;
    private Color color;
    protected String modelName;
    protected Point position;
    private double currentDirection;



    public Car(int nrDoors, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.modelName = modelName;
        this.position = new Point(0,0);
        this.currentDirection = 90;
        stopEngine();

    }


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected Color getColor() {
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
        if (currentDirection >= 360){
            currentDirection -= 360;
        }
    }
    public void turnRight() {
        //Turn Downwards
        currentDirection -=90;
        if (currentDirection < 0){
            currentDirection += 360;
        }

    }
    protected double getCurrentDirection(){
        return currentDirection;
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Wrong gas input: ");
        }
    }
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Wrong brake input: ");
        }

    }
}




