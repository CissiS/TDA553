import java.awt.*;
public abstract class Truck extends Vehicle implements Ramp {
    //Common attributes
    private final int nrDoors;
    private double rampAngle;
    private double minRampAngle;
    private double maxRampAngle;

    public Truck (int nrDoors, double enginePower, Color color, String modelName, int length) {
        super(enginePower, color, modelName, length);
        this.nrDoors = nrDoors;
    }

    @Override
    public void gas(double amount) {
        if (this.isRampPositioned()) {
            super.gas(amount);
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not right: ");
        }
    }

    @Override
    public void raise (double amount){
        if (rampAngle + amount <= minRampAngle) {
            rampAngle = Math.min(rampAngle + amount, maxRampAngle);
        } else {
            throw new IllegalArgumentException("Ramp in position or vehicle is moving: ");
        }
    }

    @Override
        public void lower(double amount) {
        if (rampAngle >= minRampAngle && currentSpeed == 0) {
            rampAngle = Math.max(rampAngle - amount, minRampAngle);
        } else {
            throw new IllegalArgumentException("Ramp in position or vehicle moving: ");
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.02;
    }


    public double getRampAngle() {
        return rampAngle;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public double getMaxRampAngle() {
        return maxRampAngle;
    }
    public double getMinRampAngle() {
        return minRampAngle;
    }
}