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
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    public CarMotionManager cmm;
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    public CarController(CarMotionManager cmm) {
        this.cmm = cmm;
        this.frame = new CarView("CarSim 1.0", this);
    }


    //methods:

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

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
        int randomNr = (int) (Math.random() * 3);
        if (randomNr == 0) {
            Factory.createVehicle("Volvo240", new Point(200, 0));
            cmm.vehicles.add(Factory.createVehicle("Volvo240", new Point(200, 0)));
            System.out.print("Volvo generated");
        } else if (randomNr == 1) {
            Factory.createVehicle("Saab95", new Point(500, 0));
            cmm.vehicles.add(Factory.createVehicle("Saab95", new Point(500, 0)));
            System.out.println("Saab generated");
        }
        else {
            Factory.createVehicle("Scania", new Point(700, 0));
            cmm.vehicles.add(Factory.createVehicle("Scania", new Point(700, 0)));
            System.out.println("Scania generated");
        }
    }

    // This actionListener is for the timer.
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : cmm.getVehicles()) {
                vehicle.move();
                boolean atEdge = vehicle.getPosition().x < 0 || vehicle.getPosition().x > 700 || vehicle.getPosition().y > 500 || vehicle.getPosition().y < 0;
                if (atEdge) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }

                int x = (int) Math.round(vehicle.getPosition().getX());
                int y = (int) Math.round(vehicle.getPosition().getY());
                frame.drawPanel.moveit(x, y, vehicle);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                cmm.loadCar(vehicle);
            }
        }
    }}



