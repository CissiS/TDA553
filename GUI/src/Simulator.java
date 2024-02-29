import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Simulator {

    private CarController carC;
    private static final int X = 800;
    private static final int Y = 800;
    private final int delay = 50;

    public Timer timer = new Timer(delay, new TimerListener());

    public Simulator() {

        CarMotionManager cmm = new CarMotionManager(new ArrayList<>(), new Workshop<>(5, new Point(0, 300)));

        cmm.VehicleListener(DrawPanel.getInstance(X,Y));

        this.carC = new CarController(cmm);
    }

    public static void main(String[] args) {
        // Skapa en instans av Simulator och kör simulationen
        Simulator simulator = new Simulator();
        simulator.setupSimulation();
    }

    public void setupSimulation() {
        // Skapa fordon och lägg till dem i modellen
        Vehicle volvo = Factory.createVehicle("Volvo240", new Point(0, 0));
        carC.cmm.vehicles.add(volvo);

        Vehicle saab = Factory.createVehicle("Saab95", new Point(200, 0));
        carC.cmm.vehicles.add(saab);

        Vehicle scania = Factory.createVehicle("Scania", new Point(400, 0));
        carC.cmm.vehicles.add(scania);
        
        // Skapa gränssnittet och starta simulationen
        DrawPanel.getInstance(X,Y).setVehicles(carC.cmm.vehicles);
        DrawPanel.getInstance(X,Y).getWorkshopImage();

        // Start the timer
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : carC.cmm.getVehicles()) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition().getX());
                int y = (int) Math.round(vehicle.getPosition().getY());
                boolean atEdge = vehicle.getPosition().x < 0 || vehicle.getPosition().x > 700 || vehicle.getPosition().y > 500 || vehicle.getPosition().y < 0;
                if (atEdge) {
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                }


                DrawPanel.getInstance(X,Y).moveit(x, y, vehicle);
                // repaint() calls the paintComponent method of the panel
                DrawPanel.getInstance(X,Y).repaint();
                carC.cmm.loadCar(vehicle);
            }
        }
    }
}