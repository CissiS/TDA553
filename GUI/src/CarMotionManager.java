import java.awt.*;
import java.util.ArrayList;
//detta är vår CarModel
import java.util.List;
public class CarMotionManager implements CarTransportHandler, VehicleListener {
    public ArrayList<Vehicle> vehicles;
    private Workshop<Volvo240> volvoWorkshop;

    public CarMotionManager(ArrayList<Vehicle> vehicles, Workshop<Volvo240> volvoWorkshop) {
        this.vehicles = vehicles;
        this.volvoWorkshop = volvoWorkshop;
    }


    public void setTurboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
                System.out.println(vehicle.getModelName() + " turbo on");
            }
        }
    }

    //Metod för att kika om Bilarna krockar med Workshops
    public double calculatePosition(Point point1, Point point2) {
        double dx = point2.getX() - point1.getX();
        double dy = point2.getY() - point1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void loadCar(Vehicle vehicle) {
        double distance = calculatePosition(vehicle.getPosition(), volvoWorkshop.getWorkshopPosition());
        final double COLLISION_DISTANCE_THRESHOLD = 20.0; // kanske ska flyttas ut till workshop eller nån annanstans
        if (distance < COLLISION_DISTANCE_THRESHOLD) {
            if (vehicle instanceof Volvo240) {
                if (!volvoWorkshop.getCars().contains((Volvo240) vehicle)) {
                    volvoWorkshop.addCar((Volvo240) vehicle);
                    vehicle.stopEngine();
                    System.out.println(vehicle.getModelName() + " added to workshop");
                }
            }
        }
    }

    @Override           //fel just nu, behövde implementera men vi behöver ej den egentligen?
    public void unloadCar() {
        if (!volvoWorkshop.getCars().isEmpty()) {
            volvoWorkshop.getCars().getFirst().startEngine();
        }
    }

    public void setTurboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
                System.out.println(vehicle.getModelName() + " turbo off");
            }
        }
    }

    @Override
    public void raise(double amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raise(amount);
            }
        }
    }

    @Override
    public void lower(double amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lower(amount);
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.gas(gas);
            System.out.println(vehicle.getModelName() + " speed: " + vehicle.getCurrentSpeed() + " position: " + vehicle.getPosition());
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles
        ) {
            vehicle.brake(brake);
            System.out.println(vehicle.getModelName() + " speed: " + vehicle.getCurrentSpeed() + " position: " + vehicle.getPosition());
        }
    }

    public void stopAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    public void startAllCars() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
            System.out.println(vehicle.getModelName() + " started");
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override           //fel just nu, behövde implementera
    public boolean isRampPositioned() {
        return calculatePosition(volvoWorkshop.getWorkshopPosition(), volvoWorkshop.getWorkshopPosition()) < 1;
    }


    private List<VehicleListener> vehicleListeners = new ArrayList<>();

    public void VehicleListener(VehicleListener listener) {
        vehicleListeners.add(listener);
    }

    protected void notifyVehicleRemoved(Vehicle vehicle) {
        for (VehicleListener listener : vehicleListeners) {
            listener.onVehicleRemoved(vehicle);
        }
    }

    protected void notifyVehicleAdded(Vehicle vehicle) {
        for (VehicleListener listener : vehicleListeners) {
            listener.onVehicleAdded(vehicle);
        }
    }

    public void generateRandomVehicle() {
        if (vehicles.size() < 10) {
            int randomNr = (int) (Math.random() * 3);
            Point newPoint = new Point((vehicles.size() * 100) % 800, 0);
            Vehicle newVehicle = null;

            switch (randomNr) {
                case 0:
                    newVehicle = Factory.createVehicle("Volvo240", newPoint);
                    System.out.println("Volvo generated");
                    break;
                case 1:
                    newVehicle = Factory.createVehicle("Saab95", newPoint);
                    System.out.println("Saab generated");
                    break;
                case 2:
                    newVehicle = Factory.createVehicle("Scania", newPoint);
                    System.out.println("Scania generated");
                    break;
                default:
                    System.out.println("Error in vehicle generation");
                    break;
            }

            if (newVehicle != null) {
                vehicles.add(newVehicle);

                notifyVehicleAdded(newVehicle);

                System.out.println(vehicles.size() + " vehicles now in the simulation");
            }
        } else {
            System.out.println("Maximum vehicle limit reached");
        }
    }


    public void removeRandomVehicle() {
        if (!vehicles.isEmpty()) {
            int randomNr = (int) (Math.random() * vehicles.size());
            Vehicle vehicle = vehicles.get(randomNr);
            vehicles.remove(vehicle);

            notifyVehicleRemoved(vehicle);

            System.out.println(vehicle.getModelName() + " removed");
            System.out.println(vehicles.size() + " vehicles left");
        }
    }

    @Override
    public void onVehicleRemoved(Vehicle vehicle) {

    }

    @Override
    public void onVehicleAdded(Vehicle vehicle) {

    }
}
