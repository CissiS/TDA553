import java.awt.*;

public abstract class Car {
//gemensamma attribut
    public int nrDoors;
    public double enginePower;
    public double currentSpeed;
    public Color color;
    public String modelName;
    public double gas;
    public double brake;
    public abstract double speedFactor();
}






// tanken är att skapa en huvudklass, car, som biltyperna ärver ifrån och sedan göra interfaces för andra metoder om det behövs.
// pga klasser endast kan ärva från en huvudklass. Finns det fler generiska metoder görs de i interface, eg turbo. 
