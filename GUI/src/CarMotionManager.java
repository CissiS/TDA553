import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//detta är vår CarModel
public class CarMotionManager implements CarTransportHandler {
    public ArrayList<Vehicle> vehicles;
    private Workshop<Volvo240> volvoWorkshop;

    public CarMotionManager(ArrayList<Vehicle> vehicles, Workshop<Volvo240> volvoWorkshop) {
        this.vehicles = vehicles;
        this.volvoWorkshop = volvoWorkshop;
    }


    public void setTurboOn() {
        for (Vehicle vehicle : vehicles)
        { if (vehicle instanceof Saab95) {
            ((Saab95) vehicle).setTurboOn();
            System.out.println(vehicle.getModelName() + " turbo on");
        }
        }
    }

    //Metod för att kika om Bilarna krockar med Workshops
    public double calculatePosition(Point point1, Point point2){
        double dx = point2.getX()-point1.getX();
        double dy = point2.getY()-point1.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public void loadCar(Vehicle vehicle){
        double distance = calculatePosition(vehicle.getPosition(), volvoWorkshop.getWorkshopPosition());
        final double COLLISION_DISTANCE_THRESHOLD = 20.0; // kanske ska flyttas ut till workshop eller nån annanstans
        if (distance < COLLISION_DISTANCE_THRESHOLD){
            if (vehicle instanceof Volvo240){
                if (!volvoWorkshop.getCars().contains((Volvo240) vehicle)) {
                    volvoWorkshop.addCar((Volvo240) vehicle);
                    vehicle.stopEngine();
                    System.out.println(vehicle.getModelName() + " added to workshop");
                }
            }
        }
    }

    @Override           //fel just nu, behövde implementera men vi behöver ej den egentligen?
    public void unloadCar(){
           if (!volvoWorkshop.getCars().isEmpty()){
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

        }
