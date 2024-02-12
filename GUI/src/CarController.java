import javax.swing.*;
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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> Vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

         cc.Vehicles.add(new Volvo240());
         cc.Vehicles.add(new Saab95());
         cc.Vehicles.add(new Scania());

         cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : Vehicles) {
                vehicle.move();
                boolean atEdge = vehicle.getPosition().x < 0 || vehicle.getPosition().x > 800 || vehicle.getPosition().y > 800 || vehicle.getPosition().y < 0;
                if (atEdge) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }

                int x = (int) Math.round(vehicle.getPosition().getX());
                int y = (int) Math.round(vehicle.getPosition().getY());
                frame.drawPanel.moveit(x, y, vehicle);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
    public void setTurboOn() {
        for (Vehicle vehicle : Vehicles)
        { if (vehicle instanceof Saab95) {
            ((Saab95) vehicle).setTurboOn();
            }
        }
    }

     public void setTurboOff() {
         for (Vehicle vehicle : Vehicles) {
             if (vehicle instanceof Saab95) {
                 ((Saab95) vehicle).setTurboOff();
             }
         }
     }

     public void raise(int amount) {
        for (Vehicle vehicle : Vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raise(amount);
            }
        }
    }

    public void lower(int amount) {
        for (Vehicle vehicle : Vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lower(amount);
            }
        }
    }     

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : Vehicles
                ) {
            vehicle.gas(gas);
            System.out.println(vehicle.getModelName() + " speed: " + vehicle.getCurrentSpeed() + " position: " + vehicle.getPosition());
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : Vehicles
                ) {
            vehicle.brake(brake);
            System.out.println(vehicle.getModelName() + " speed: " + vehicle.getCurrentSpeed() + " position: " + vehicle.getPosition());
        }
    }
}
