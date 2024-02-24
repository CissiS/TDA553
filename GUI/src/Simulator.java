import java.awt.*;
import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        // Instance of this class
        CarController carC = new CarController(new CarMotionManager(new ArrayList<>(), new Workshop<>(5, new Point(0,300))));

        Vehicle volvo = Factory.createVehicle("Volvo240", new Point(0, 0));
        carC.cmm.vehicles.add(volvo);

        // ändra position här!!!!
        Vehicle saab = Factory.createVehicle("Saab95", new Point(200, 0));
        carC.cmm.vehicles.add(saab);

        Vehicle scania = Factory.createVehicle("Scania", new Point(400, 0));
        carC.cmm.vehicles.add(scania);


        carC.frame = new CarView("CarSim 1.0", carC);
        carC.frame.drawPanel.setVehicles(carC.cmm.vehicles);
        carC.frame.drawPanel.getWorkshopImage();


        // Start the timer
        carC.timer.start();
    }
}