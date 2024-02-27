import java.awt.*;
public abstract class Car extends Vehicle{
    //Common attributes
    private final int nrDoors;


    public Car (int nrDoors, double enginePower, Color color, String modelName, int length, String imagePath) {
        super(enginePower, color, modelName, length, imagePath);
        this.nrDoors = nrDoors;
    }

    public int getNrDoors() {
        return nrDoors;
    }

}





