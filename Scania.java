import java.awt.*;

public class Scania extends Truck implements Ramp {

    public Scania() {
        super(2,250, Color.pink, "Scania", 4);
    }

    @Override
    public boolean isRampPositioned() {
        return this.getRampAngle() == this.getMinRampAngle();
    }

}

