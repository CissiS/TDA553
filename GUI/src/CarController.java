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
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
    public Workshop<Volvo240>  volvoWorkshop = new Workshop<Volvo240>(5, new Point(0,300));
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(new Point(0,0));
        cc.vehicles.add(volvo);

        // ändra position här!!!!
         Saab95 saab = new Saab95();
         saab.setPosition(new Point(200,0));
         cc.vehicles.add(saab);

        Scania scania = new Scania();
        scania.setPosition(new Point(400,0));
         cc.vehicles.add(scania);


        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.setVehicles(cc.vehicles);
        cc.frame.drawPanel.getWorkshopImage();


        // Start the timer
        cc.timer.start();
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
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
                addCar(vehicle);
            }
        }
    }


    public void setTurboOn() {
        for (Vehicle vehicle : vehicles)
        { if (vehicle instanceof Saab95) {
            ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    //Metod för att kika om Bilarna krockar med Workshops
    public double calculatePosition(Point point1, Point point2){
        double dx = point2.getX()-point1.getX();
        double dy = point2.getY()-point1.getY();
        return Math.sqrt(dx*dx + dy*dy);
    }

    public void addCar(Vehicle vehicle) {
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

     public void setTurboOff() {
         for (Vehicle vehicle : vehicles) {
             if (vehicle instanceof Saab95) {
                 ((Saab95) vehicle).setTurboOff();
             }
         }
     }

     public void raise(int amount) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raise(amount);
            }
        }
    }

    public void lower(int amount) {
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
        }
    }
}
