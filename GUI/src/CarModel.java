import java.awt.Point;
import java.util.ArrayList;

public class CarModel {
    private ArrayList<Vehicle> vehicles;

    public CarModel() {
        this.vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void moveVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }

    // flyttad från CarController
    public void generateRandomVehicle() {
        int randomNr = (int) (Math.random() * 3);
        Vehicle newVehicle = null;
        if (randomNr == 0) {
            newVehicle = Factory.createVehicle("Volvo240", new Point(200, 0));
        } else if (randomNr == 1) {
            newVehicle = Factory.createVehicle("Saab95", new Point(500, 0));
        } else {
            newVehicle = Factory.createVehicle("Scania", new Point(700, 0));
        }
        addVehicle(newVehicle);
        System.out.println(newVehicle.getModelName() + " generated");

    }
}