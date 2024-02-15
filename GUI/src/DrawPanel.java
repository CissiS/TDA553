
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    public ArrayList<CarImage> carImages = new ArrayList<>();
    BufferedImage volvoWorkshopImage;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
        // this.loadImages();
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            BufferedImage image = getImageForModel(vehicle.getModelName());
        if (image != null) {
            carImages.add(new CarImage(vehicle.getModelName(), image, vehicle.getPosition()));
        }
    }
}


    public BufferedImage getImageForModel(String modelName) {
        try {
            String imagePath = "pics/" + modelName + ".jpg";
            return ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public BufferedImage getWorkshopImage() {
        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            return volvoWorkshopImage;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (CarImage carImage : carImages) {
                g.drawImage(carImage.image, carImage.position.x, carImage.position.y, this);if (volvoWorkshopImage != null)
                g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, this);
        }
        if (volvoWorkshopImage != null)
            g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, this);
    }

    void moveit(int x, int y, Vehicle vehicle) {
        for (CarImage carImage : carImages) {
            if (carImage.modelName.equals(vehicle.getModelName())) {
                carImage.position.x = x;
                carImage.position.y = y;
                break;
            }
        }
    }

    public class CarImage {
        String modelName;
        BufferedImage image;
        Point position;
        public CarImage(String modelName, BufferedImage image, Point position){
            this.modelName = modelName;
            this.image = image;
            this.position = position;
        }
    }


    // Just a single image, TODO: Generalize

    Point volvoWorkshopPoint = new Point(0, 300);

    // TODO: Make this general for all cars


}

