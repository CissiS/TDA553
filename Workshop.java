import java.util.ArrayList;
import java.awt.*;

public class Workshop <model extends Car> {
    // Parametrisk polymorfism, specificera vilken typ av bilar Workshop kan hantera
    // E.g. specify that 'type' is a subtype from 'Volvo'
    // A workshop that only can handle Volvo is Workshop<VolvoCar>
    private ArrayList<model> cars;
    private Point position = new Point(0,0);
    private final int capacity;

    private String imagePath;

    public Workshop(int capacity, Point position, String imagePath) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
        this.position = position;
        this.imagePath = imagePath;
    }

    public void addCar(model car) {
    if (cars.size() < capacity) {
        // Is it the valid car type?
        // Will also exceed if the workshop takes all cars
        // Or if the car is an instance of the accepted type
        cars.add(car);
    }
    else {
        throw new IllegalArgumentException("Workshop is full");
    }
    }

    public void removeCar(model car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
        else {
            throw new IllegalArgumentException("Car not in workshop");
        }
    }

    public String getWorkshopPic(){
        return imagePath;
    }
    public ArrayList<model> getCars() {
        return cars;
    }
    public Point getWorkshopPosition() {return position;}

}
