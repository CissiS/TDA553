import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {
    private Volvo240 myvolvo;
    private Saab95 mysaab;

    private Workshop<Volvo240> workshop;

    @BeforeEach
    void setUp() {
        mysaab = new Saab95();
        myvolvo = new Volvo240();
        workshop = new Workshop<Volvo240>(2, new Point(0,0));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCar() {
        workshop.addCar(myvolvo);
        assertEquals(1, workshop.getCars().size());
        workshop.addCar(myvolvo);
        assertThrows(IllegalArgumentException.class, () -> workshop.addCar(myvolvo));
    }

    @Test
    void removeCar() {
        workshop.addCar(myvolvo);
        workshop.removeCar(myvolvo);
        assertEquals(0, workshop.getCars().size());
        assertThrows(IllegalArgumentException.class, () -> workshop.removeCar(myvolvo));
    }
}