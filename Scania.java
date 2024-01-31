import java.awt.*;

public class Scania extends Car implements Trailer {

    private double trailerAngle;
    private static final double max_platformAngle = 70;
    private static final double min_platformAngle = 0;
    public Scania() {
        super(2,250, Color.pink, "Scania", 4);
    }

    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && trailerAngle == 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not 0: ");
        }
    }

    public void raise(double amount) {
        if (currentSpeed == 0) {
            trailerAngle= Math.min(trailerAngle+amount, max_platformAngle);
        }
        else {
            throw new IllegalArgumentException("Truck might be moving: ");
        }
    }

    public void lower(double amount) {
            trailerAngle = Math.max(trailerAngle - amount, min_platformAngle);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.02;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public double getTrailerAngle() {
        return trailerAngle;
    }
}

