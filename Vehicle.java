import java.awt.*;
import java.util.UUID;

public abstract class  Vehicle implements Movable{
    //Common attributes
    private final double enginePower;
    protected double currentSpeed;
    private Color color;
    protected String modelName;
    protected Point position;
    private double currentDirection;
    private final int length;

    public boolean engineState;
    private String id;


    public Vehicle(double enginePower, Color color, String modelName, int length) {
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point(0,0);
        this.currentDirection = 90;
        this.length = length;
        this.id = UUID.randomUUID().toString();
        stopEngine();
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

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
        if (amount >= 0 && amount <= 1 && engineState) {
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
        engineState = true;
    }

    public void stopEngine() {
        currentSpeed = 0;
        engineState = false;
    }

    public int getlength() {
        return length;
    }

    protected void setPosition(Point position){
        this.position = position;
    }

    public String getHashCode() {
        return String.valueOf(this.hashCode());
    }


    public String getModelName() {
        return modelName;
    }

    public Point getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return modelName.equals(vehicle.modelName);
    }

    @Override
    public int hashCode() {
        return modelName.hashCode();
    }

}




