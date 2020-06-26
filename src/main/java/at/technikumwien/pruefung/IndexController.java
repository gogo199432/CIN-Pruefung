package at.technikumwien.pruefung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    private CarRepository carRepository;
    @RequestMapping
    public String index(Model model){
        var cars = carRepository.findAll();

        model.addAttribute("cars",cars);

        return "index";
    }
}
