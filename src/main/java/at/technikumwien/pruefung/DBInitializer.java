package at.technikumwien.pruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("default")
public class DBInitializer {
    @Autowired
    private CarRepository carRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent(){
        carRepository.saveAll(List.of(
                new Car(
                    1l,"Ford","Mustang", LocalDate.of(1964,05,17)
                ),
                new Car(
                        2l,"Toyota","That other car", LocalDate.of(2000,03,02)
                )
        ));
    }
}
