
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    public ArrayList<CarImage> carImages = new ArrayList<>();
    BufferedImage volvoWorkshopImage;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        this.loadImages();
        }

public void loadImages(){       //använd endast modelname och kolla så de samma typ på de sättet.
        // Print an error message in case file is not found with a try/catch block
        try {
            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            BufferedImage volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            carImages.add(new CarImage(new Volvo240(), volvoImage, new Point(0,0)));

            BufferedImage saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            carImages.add(new CarImage(new Saab95(), saabImage, new Point(200,0)));

            BufferedImage scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            carImages.add(new CarImage(new Scania(), scaniaImage, new Point(400,0)));

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for (CarImage carImage : carImages) {
                g.drawImage(carImage.image, carImage.position.x, carImage.position.y, null);g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

        }
    }

    void moveit(int x, int y, Vehicle vehicle) {
        for (CarImage carImage : carImages) {
            if (carImage.vehicle.equals(vehicle)) {
                carImage.position.x = x;
                carImage.position.y = y;
                break;
            }
        }
    }

    public class CarImage {
        Vehicle vehicle;
        BufferedImage image;
        Point position;
        public CarImage(Vehicle vehicle, BufferedImage image, Point position){
            this.vehicle = vehicle;
            this.image = image;
            this.position = position;
        }
    }


    // Just a single image, TODO: Generalize

    //BufferedImage volvoWorkshopImage;
    public Point volvoWorkshopPoint = new Point(0,300);

    // TODO: Make this general for all cars



}
