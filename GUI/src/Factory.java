import java.awt.*;
import java.rmi.UnexpectedException;

public class Factory {
    public static Vehicle createVehicle(String type, Point position) {
        switch (type) {
            case "Volvo240":
                Volvo240 volvo = new Volvo240();
                volvo.setPosition(position);
                return volvo;
            case "Saab95":
                Saab95 saab = new Saab95();
                saab.setPosition(position);
                return saab;
            case "Scania":
                Scania scania = new Scania();
                scania.setPosition(position);
                return scania;
            default:
                throw new IllegalArgumentException("Invalid vehicle type!" + type);
        }
    }
}
