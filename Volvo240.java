import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    protected double currentDirection = 90; //Bilen åker rakt fram från början (i positiv y-riktning) ska den det??
    protected double x = 0;
    protected double y = 90;
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

//    @Override
//    public void move() {
//        double currentRadian = Math.toRadians(currentDirection);
//        double movement_x = currentSpeed * Math.cos(currentRadian);
//        double movement_y = currentSpeed * Math.sin(currentRadian);
//
//        x += movement_x;
//        y += movement_y;
//    }
//
//    @Override
//    public void turnLeft() {
//        currentDirection += 90;
//        if (current >= 360) {
//            currentDirection -= 360;
//        }
//    }
//}
//
//    @Override
//    public void turnRight(){
//        currentDirection -= 90;
//        if (currentDirection <= 0) {
//            currentDirection += 360;
//        }


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
