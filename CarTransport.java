import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Car implements CarTransportHandler{
    protected double platformAngle;
    protected static int maxLoad = 8;

    private static final double max_platformAngle = 70;
    private static final double min_platformAngle = 0;
    public Deque<Car> cars;

    public CarTransport(){
        super(2,300, Color.cyan, "CarCarrier", 6);
        cars = new ArrayDeque<>();
        platformAngle = max_platformAngle;
        stopEngine();
    }

    @Override
    public void move() {
        super.move();
        for (Car car : cars) {
            car.position.x = position.x;
            car.position.y = position.y;
        }
    }

    @Override
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 && platformAngle == max_platformAngle) {
            incrementSpeed(amount);
        } else {
            throw new IllegalArgumentException("Gas input either too high or too low, or trailer angle not 0: ");
        }
    }

    protected void incrementAngle(double amount) {
        platformAngle = platformAngle + amount;
    }

    protected void decrementAngle(double amount) {
        platformAngle = platformAngle - amount;
    }
    @Override
    public void raiseRamp() {
        if (platformAngle == min_platformAngle) {
            platformAngle = max_platformAngle;
        } else {
            throw new IllegalArgumentException("Max angle reached: ");
        }
    }

    @Override
    public void lowerRamp() {
        if (platformAngle == max_platformAngle && currentSpeed == 0) {
            platformAngle = min_platformAngle;
        } else {
            throw new IllegalArgumentException("Ramp already lowered or vehicle moving: ");
        }
    }

    @Override
    public void loadCar(Car car) {
        if (isCarCloseTo(car) && platformAngle == min_platformAngle && !(car instanceof CarTransport) && cars.size() < maxLoad && car.getlenght() <= 2) {
            // CarTransports can not be loaded on any instance of CarTransport
            cars.add(car);
        } else {
            throw new IllegalStateException("Car not in position, ramp not lowered or it's a CarCarrier: ");
        }
    }

    @Override
    public void unloadCar() {
        if (!cars.isEmpty() && platformAngle == min_platformAngle) {
            cars.removeLast();
        } else {
            throw new IllegalArgumentException("Car not on trailer or ramp not lowered:");
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
