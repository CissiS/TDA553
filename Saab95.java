import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    protected double currentDirection = 90; //Bilen åker rakt fram från början (i positiv y-riktning) ska den det??
    protected double x = 0;
    protected double y = 90;

    public void setTurboOn() {turboOn = true;}
    public void setTurboOff() {turboOn = false;}

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


    @Override
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
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
