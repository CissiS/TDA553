import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    
    public Saab95(){
        super(2, 125,"Saab95");
        setColor(Color.red);
	    turboOn = false;
    }

    
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        // The speed should not be below 0?
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
        turboOn = false;
    }}

