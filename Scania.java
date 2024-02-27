import java.awt.*;

public class Scania extends Truck{

    public Scania() {
        super(2,100, Color.pink, "Scania", 4, "pics/Scania.jpg");
    }

    @Override
    public boolean isRampPositioned() {
        return this.getRampAngle() == this.getMinRampAngle();
    }

}

