package at.technikumwien.pruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("resources/cars")
public class CarResource {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/{id}")
    public Car retrieve(
            @PathVariable long id
    ){
        return carRepository.findById(id).get();
    }

    @GetMapping
    public List<Car> retrieveAll(){
            return carRepository.findAll();
    }
}
