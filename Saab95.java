import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    
    public Saab95(){
        super(2, 125, Color.red, "Saab95", 2);
        setColor(Color.red);
	    turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
        turboOn = false;
    }}

