import java.awt.*;

public class Scania extends Car {

    protected double trailerAngle;
    public Scania() {
        super(2,250, Color.pink, "Scania");
    }

    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && trailerAngle == 0) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not 0: ");
        }
    }
    protected void incrementAngle(double amount) {
        trailerAngle = trailerAngle + amount;
    }

    protected void decrementAngle(double amount) {
        trailerAngle = trailerAngle - amount;
    }

    public void liftTrailer(double amount) {
        if ((trailerAngle + amount) <= 70 && (currentSpeed == 0)) {
            incrementAngle(amount);
        }
        else {
            throw new IllegalArgumentException("Max angle reached or truck might be moving: ");
        }
    }

    public void lowerTrailer(double amount) {
        if (trailerAngle - amount >= 0) {
            decrementAngle(amount);
        }
        else {
            throw new IllegalArgumentException("Min angle reached: ");
        }
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

}

}