import java.awt.*;
public abstract class Car extends Vehicle{
    //Common attributes
    private final int nrDoors;


    public Car (int nrDoors, double enginePower, Color color, String modelName, int length, Point position) {
        super(enginePower, color, modelName, length, position);
        this.position = position;
        this.nrDoors = nrDoors;
    }

    public int getNrDoors() {
        return nrDoors;
    }

}





