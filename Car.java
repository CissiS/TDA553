
public abstract class Car implements Movable {
//gemensamma attribut
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Colour color;
    protected String modelName;
    protected double gas;
    protected double brake;
    protected double currentDirection = 90; //Bilen åker rakt fram från början (i positiv y-riktning) ska den det??
    protected double x = 0;
    protected double y = 90;


    protected abstract double speedFactor();

    @Override
    public void move() {
        double currentRadian = Math.toRadians(currentDirection);
        double movement_x = currentSpeed * Math.cos(currentRadian);
        double movement_y = currentSpeed * Math.sin(currentRadian);

        x += movement_x;
        y += movement_y;
    }

    @Override
    public void turnLeft() {
        currentDirection += 90;
            if (current >= 360) {
                currentDirection -= 360
            }
            }
    }
    
    @Override
    public void turnRight(){
        currentDirection -= 90;
            if (currentDirection <= 0) {
                currentDirection += 360
    }

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
}




// tanken är att skapa en huvudklass, car, som biltyperna ärver ifrån och sedan göra interfaces för andra metoder om det behövs.
// pga klasser endast kan ärva från en huvudklass. Finns det fler generiska metoder görs de i interface, eg turbo. 
