import java.awt.*;

public class Scania extends Truck implements Ramp {

    public Scania() {
        super(2,200, Color.pink, "Scania", 4, new Point(300,0));
    }

    @Override
    public boolean isRampPositioned() {
        return this.getRampAngle() == this.getMinRampAngle();
    }

}

