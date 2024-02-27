import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class CarTransport extends Truck implements CarTransportHandler{
    protected static int maxLoad = 8;
    public Deque<Vehicle> cars;

    public CarTransport(){
        super(2,300, Color.cyan, "CarCarrier", 6, "pics/CarCarrier.jpg");
        cars = new ArrayDeque<>();
        stopEngine();
    }

    public boolean isCarCloseTo(Vehicle vehicle) {
        return (Math.abs(vehicle.position.x - this.position.x) <= 1 && Math.abs(vehicle.position.y - this.position.y) <= 1);
    }

    public void setRampToExtreme(boolean raise) {
        if (raise) {
            while (this.getRampAngle() < this.getMaxRampAngle()) {
                this.raise(this.getMaxRampAngle() - this.getRampAngle());
            }
        } else {
            while (this.getRampAngle() > this.getMinRampAngle()) {
                this.lower(this.getRampAngle());
            }
        }
    }

    @Override
    public void raise(double amount) {
        if (this.isRampPositioned()) {
            setRampToExtreme(true);
        } else {
            throw new IllegalArgumentException("CarTransport moving");
        }
    }

    @Override
    public void lower(double amount) {
        if (this.isRampPositioned()) {
            setRampToExtreme(false);
        } else {
            throw new IllegalArgumentException("CarTransport moving");
        }
    }

    @Override
    public boolean isRampPositioned() {
        return this.getRampAngle() == this.getMaxRampAngle();
    }

    @Override
    public void loadCar(Vehicle vehicle) {
        if (vehicle instanceof Car && isCarCloseTo(vehicle) && this.getRampAngle() == this.getMinRampAngle()  && cars.size() < maxLoad && vehicle.getlength() <= 2) {
            // CarTransports can not be loaded on any instance of CarTransport
            cars.add(vehicle);
        } else {
            throw new IllegalStateException("Car not in position, ramp not lowered or it's a CarCarrier: ");
        }
    }

    @Override
    public void unloadCar() {
        if (!cars.isEmpty() && this.getRampAngle() == this.getMinRampAngle()) {
            cars.removeLast();
        } else {
            throw new IllegalArgumentException("Car not on trailer or ramp not lowered:");
        }
    }

}
