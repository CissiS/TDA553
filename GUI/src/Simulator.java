import java.awt.*;
import java.util.ArrayList;

public class Simulator {

    private CarController carController;

    public Simulator() {
        // Skapa en instans av CarController;
        this.carController = new CarController(new CarMotionManager(new ArrayList<>(), new Workshop<>(5, new Point(0, 300))));
    }

    public static void main(String[] args) {
        // Skapa en instans av Simulator och kör simulationen
        Simulator simulator = new Simulator();
        simulator.setupSimulation();
    }

    public void setupSimulation() {
        // Skapa fordon och lägg till dem i modellen
        Vehicle volvo = Factory.createVehicle("Volvo240", new Point(0, 0));
        carController.cmm.vehicles.add(volvo);

        Vehicle saab = Factory.createVehicle("Saab95", new Point(200, 0));
        carController.cmm.vehicles.add(saab);

        Vehicle scania = Factory.createVehicle("Scania", new Point(400, 0));
        carController.cmm.vehicles.add(scania);

        // Skapa gränssnittet och starta simulationen
        carController.frame.drawPanel.setVehicles(carController.cmm.vehicles);
        carController.frame.drawPanel.getWorkshopImage();

        // Start the timer
        carController.timer.start();
    }
}