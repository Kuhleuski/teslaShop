package com.academy.xzxz.controller;


import com.academy.xzxz.model.CarStatus;
import com.academy.xzxz.service.dto.CarDto;
import com.academy.xzxz.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class CarController {


    private final CarService carService;
    private final BodyService bodyService;
    private final EquipmentService equipmentService;
    private final WheelService wheelService;
    private final ColorService colorService;

    @GetMapping()
    public String carList(Model model) {
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("message", "Склад пустой")
        ;model.addAttribute("title",
                "Список автомобилей Tesla");
        return "car/car-list";
    }


    @PostMapping("/delete-car={id}")
    public String deleteCarPost(@PathVariable(value = "id") int id) {
        carService.deleteById(id);
        return "redirect:/car";
    }


    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("car", carService.findById(id));
        return "car/car-details";
    }

    @GetMapping("/create-car")
    public String createCar( Model model) {
        model.addAttribute("bodyList", bodyService.findAll());
        model.addAttribute("title",
                "Создать новый автомобиль Tesla");
        return "car/create-car";

    }


    @GetMapping("/create={id}")
    public String createCarGet(@PathVariable(value = "id") int id, Model model) {

        model.addAttribute("allEquipments", equipmentService.findAllEnginesForCurrentBody(id));
        model.addAttribute("allWheels", wheelService.findAll());
        model.addAttribute("allColors", colorService.findAll());
        model.addAttribute("body", bodyService.findById(id));
        model.addAttribute("title", "Создать  Tesla " + bodyService.findById(id).getName());
        return "car/for-body";
    }


    @PostMapping("/create={id}")
    public String createCraPost( @PathVariable(value = "id") int id,
                             @RequestParam int equipmentId,
                             @RequestParam int bodyId,
                             @RequestParam(defaultValue = "false") boolean toning,
                             @RequestParam int colorId,
                             @RequestParam int wheelId) {
        carService.createNewCar(bodyId,equipmentId,wheelId,  CarStatus.ACTIVE, toning, colorId);
        return "redirect:/car";
    }


    @GetMapping("/update-car={id}")
    public String carUpdate(@PathVariable(value = "id") int id, Model model) {

        CarDto car = carService.findById(id);
        model.addAttribute("car", car);
        model.addAttribute("allEquipments", equipmentService.findAllEnginesForCurrentBody(id));
        model.addAttribute("allWheels", wheelService.findAll());
        model.addAttribute("allColors", colorService.findAll());
        model.addAttribute("title",
                "Редактировать автомобиль Tesla " + car.getBody().getName() + " " + car.getEquipment().getName());

        return "car/update-car";
    }

    @PostMapping("/update-car={id}")
    public String carPostUpdate(@PathVariable(value = "id") int id,

                                      @RequestParam int equipmentId,
                                      @RequestParam int colorId,
                                      @RequestParam int wheelId) {
        carService.updateCar(id,equipmentId,wheelId,colorId);
        return "redirect:/car";
    }

}

