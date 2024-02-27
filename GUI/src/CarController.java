import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {


    public CarMotionManager cmm;
    CarView frame;
    public CarController(CarMotionManager cmm) {
        this.cmm = cmm;
        this.frame = new CarView("CarSim 1.0", this);
    }

    public void gas(int amount) {
        cmm.gas(amount);
    }

    public void brake(int amount) {
        cmm.brake(amount);
    }
    public void startAllCars() {
        cmm.startAllCars();
    }

    public void stopAllCars() {
        cmm.stopAllCars();
    }

    public void turboOn() {
        cmm.setTurboOn();
    }

    public void turboOff() {
        cmm.setTurboOff();
    }

    public void raise(int amount) {
        cmm.raise(amount);
    }

    public void lower(int amount) {
        cmm.lower(amount);
    }

    public void loadCar(Vehicle vehicle) {
        cmm.loadCar(vehicle);
    }

    public void generateRandomVehicle() {
        if (cmm.vehicles.size() < 10) {
            int randomNr = (int) (Math.random() * 3);
            Point newPoint = new Point((cmm.vehicles.size() * 100) % 800, 0);
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
                cmm.vehicles.add(newVehicle);
                frame.drawPanel.addVehicleImage(newVehicle);
                frame.drawPanel.repaint();
                System.out.println(cmm.vehicles.size() + " vehicles now in the simulation");
            }
        } else {
            System.out.println("Maximum vehicle limit reached");
        }
    }


    public void removeRandomVehicle() {
        if (!cmm.vehicles.isEmpty()) {
            int randomNr = (int) (Math.random() * cmm.vehicles.size());
            Vehicle vehicle = cmm.vehicles.get(randomNr);
            cmm.vehicles.remove(vehicle);
            frame.drawPanel.removeVehicleImage(vehicle);
            frame.drawPanel.repaint();
            System.out.println(vehicle.getModelName() + " removed");
            System.out.println(cmm.vehicles.size() + " vehicles left");
        }
    }
}



