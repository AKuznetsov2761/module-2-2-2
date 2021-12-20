package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String cars (@RequestParam(value = "count", defaultValue = "5")Integer count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "1.8", "blue"));
        cars.add(new Car("Audi", "2.8", "black"));
        cars.add(new Car("VW", "1.8", "grey"));
        cars.add(new Car("Renault", "1.6", "red"));
        cars.add(new Car("Opel", "2.4", "wet-asphalt"));
        cars.add(new Car("Lada", "1.6MT", "magenta"));
        cars.add(new Car("ZAZ", "1.2MT", "white"));
        model.addAttribute("cars", CarsService.carsCount(cars, count));
        return "car";
    }

}