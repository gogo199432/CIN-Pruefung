package at.technikumwien.pruefung;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Tag("integration-test")
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    public void testSave(){
        var countBefore = carRepository.count();
        var car = carRepository.save(new Car(
                3l,"Tesla","Teslaer", LocalDate.of(2020,07,29)
        ));
        assertNotNull(car.getId());
        assertEquals(countBefore+1, carRepository.count());
    }
}
