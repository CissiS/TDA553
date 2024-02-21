import java.awt.*;
import java.util.ArrayList;

public class Simulator {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Vehicle volvo = Factory.createVehicle("Volvo240", new Point(0, 0));
        cc.vehicles.add(volvo);

        // ändra position här!!!!
        Vehicle saab = Factory.createVehicle("Saab95", new Point(200, 0));
        cc.vehicles.add(saab);

        Vehicle scania = Factory.createVehicle("Scania", new Point(400, 0));
        cc.vehicles.add(scania);


        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.setVehicles(cc.vehicles);
        cc.frame.drawPanel.getWorkshopImage();


        // Start the timer
        cc.timer.start();
    }
}