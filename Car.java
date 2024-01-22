import java.awt.*;

public abstract class Car implements Movable {
    //gemensamma attribut
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected double gas;
    protected double brake;
    protected double currentDirection; //Bilen åker rakt fram från början (i positiv y-riktning) ska den det??
    protected Point position;

    protected abstract double speedFactor();

    public Car(int nrDoors, double enginePower, Color color, String modelName, Point position) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentDirection = 90;
        this.position = position;
        this.gas = 0;
        this.brake = 0;
    }

    public void move() {
        double currentRadian = Math.toRadians(currentDirection);
        double movement_x = currentSpeed * Math.cos(currentRadian);
        double movement_y = currentSpeed * Math.sin(currentRadian);

        position.x += movement_x;
        position.y += movement_y;
    }


    public void turnLeft() {
        currentDirection += 90;
        if (currentDirection >= 360) {
            currentDirection -= 360;
        }
    }


    public void turnRight() {
        currentDirection -= 90;
        if (currentDirection < 0) {
            currentDirection += 360;
        }
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    protected int getNrDoors() {
        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }

    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    protected void startEngine() {
        currentSpeed = 0.1;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }


    protected double getCurrentDirection() {
        return currentDirection;
    }
}



// tanken är att skapa en huvudklass, car, som biltyperna ärver ifrån och sedan göra interfaces för andra metoder om det behövs.
// pga klasser endast kan ärva från en huvudklass. Finns det fler generiska metoder görs de i interface, eg turbo.
