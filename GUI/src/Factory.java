import java.awt.*;
import java.util.*;
import java.rmi.UnexpectedException;

public class Factory {
    private static final Map<String, Vehicle> createdVehicles = new HashMap<>();

    public static Vehicle createVehicle(String type, Point position) {
        Vehicle vehicle = switch (type) {
            case "Volvo240" -> new Volvo240();
            case "Saab95" -> new Saab95();
            case "Scania" -> new Scania();
            default -> throw new IllegalArgumentException("Invalid vehicle type" + type);
        };
        vehicle.setPosition(position);
        String id = UUID.randomUUID().toString();
        createdVehicles.put(id, vehicle);
        return vehicle;
        }
}
