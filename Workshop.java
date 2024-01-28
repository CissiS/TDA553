import java.util.ArrayList;

public abstract class Workshop<type extends Car> {
    private ArrayList<type> cars;
    private int capacity;


    public Workshop(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public void addCar(type car) {      //vill man att alla utom en bilsort ska va me får man lägga till logik här
    if (cars.size() < capacity) {       // typ att workshop tar in "Car" men man throwar illegalargument om bil = carcarrier
        cars.add(car);
    }
    else {
        throw new IllegalArgumentException("Workshop is full");
    }
    }

    public void removeCar(type car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
        else {
            throw new IllegalArgumentException("Car not in workshop");
        }
    }

}
