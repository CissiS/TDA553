import java.awt.*;
public abstract class Truck extends Vehicle implements Ramp {
    //Common attributes
    private final int nrDoors;
    private double rampAngle;
    private final double minRampAngle = 0;
    private final double maxRampAngle = 70;

    public Truck (int nrDoors, double enginePower, Color color, String modelName, int length, String imagePath) {
        super(enginePower, color, modelName, length, imagePath);
        this.nrDoors = nrDoors;
    }

    @Override
    public void gas(double amount) {
        if (this.isRampPositioned() && engineState) {
            super.gas(amount);
            //isRampPositioned();
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not right: ");
        }
    }

    @Override
    public void raise (double amount){
        // Anropar raise till max maxvinkeln, men bara om bilen står stilla
        if (getCurrentSpeed() == 0 && rampAngle + amount <= maxRampAngle) {
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

    public double getMaxRampAngle() {
        return maxRampAngle;
    }
    public double getMinRampAngle() {
        return minRampAngle;
    }
}