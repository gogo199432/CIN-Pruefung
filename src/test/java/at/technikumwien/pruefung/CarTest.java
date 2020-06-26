package at.technikumwien.pruefung;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp(){
        car = new Car(
                1l,"Ford","Mustang", LocalDate.of(1964,05,17)
        );
    }

    @Test
    public void testGetName(){
        assertEquals("Ford Mustang", car.getName());
    }

    @Test
    public void testGetNameWithBrandNull(){
        car.setBrand(null);

        assertThrows(IllegalArgumentException.class, () -> car.getName());
    }

    @Test
    public void testGetNameWithBrandBlank(){
        car.setBrand(" ");

        assertThrows(IllegalArgumentException.class, () -> car.getName());
    }
}
