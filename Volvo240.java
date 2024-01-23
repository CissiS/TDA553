import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;


    public Volvo240(){
        super(4,100, Color.black,0, "Volvo240", new Point(0,0));
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
    }

    public void decrementSpeed(double amount){
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
