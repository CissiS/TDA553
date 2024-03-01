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
    private static final int X = 800;
    private static final int Y = 800;

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
    public void generateRandomVehicle() {cmm.generateRandomVehicle();}
    public void removeRandomVehicle() {
        cmm.removeRandomVehicle();
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

}


