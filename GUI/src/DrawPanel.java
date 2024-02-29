
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements VehicleListener {
    private static DrawPanel instance;
    public ArrayList<CarImage> carImages = new ArrayList<>();
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(0, 300);


    private DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }

    public static DrawPanel getInstance(int x, int y) {
        if (instance == null) {
            instance = new DrawPanel(x, y);
        }
        return instance;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            BufferedImage image = getImageForModel(vehicle.getModelName());
            if (image != null) {
                carImages.add(new CarImage(vehicle.getModelName(), image, vehicle.getPosition(), vehicle.getId()));
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
            if (carImage.id.equals(vehicle.getId())) {
                carImage.position.x = x;
                carImage.position.y = y;
                break;
            }
        }
    }

    public void addVehicleImage(Vehicle vehicle) {
        BufferedImage image = getImageForModel(vehicle.getModelName());
        if (image != null) {
            carImages.add(new CarImage(vehicle.getModelName(), image, vehicle.getPosition(), vehicle.getId()));
        }
    }

    public void removeVehicleImage(Vehicle vehicle) {
        System.out.println("Jag är här wallah");

        for (CarImage carImage : carImages) {
            if (carImage.id.equals(vehicle.getId())) {
                carImages.remove(carImage);
                break;
            }
        }
    }

    @Override
    public void onVehicleRemoved(Vehicle vehicle) {
        removeVehicleImage(vehicle);
    }

    @Override
    public void onVehicleAdded(Vehicle vehicle) {
        addVehicleImage(vehicle);
    }


    public class CarImage {
        String modelName;
        BufferedImage image;
        Point position;

        String id;
        public CarImage(String modelName, BufferedImage image, Point position, String id){
            this.modelName = modelName;
            this.image = image;
            this.position = position;
            this.id = id;
        }
    }
}

