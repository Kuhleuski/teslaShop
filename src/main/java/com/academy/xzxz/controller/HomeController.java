package com.academy.xzxz.controller;

import com.academy.xzxz.model.Car;
import com.academy.xzxz.model.User;
import com.academy.xzxz.service.interfaces.CarService;
import com.academy.xzxz.service.mappers.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("userId", user.getId());
            model.addAttribute("userRole", user.getRoles());

            model.addAttribute("carList", carService.findAll());
            model.addAttribute("message", "Автомобили Tesla в наличии");


            return "index";
        }
        model.addAttribute("username", "undefined");
        model.addAttribute("userId", "none");
        model.addAttribute("userRole", "GUEST");
        model.addAttribute("carList", carService.findAll());
        model.addAttribute("message", "Автомобили Tesla в наличии");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/foruser")
    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('USER')")
    public String forUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userId", user.getId());
        return "foruser";
    }

    @GetMapping("/foradmin")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public String forAdmin(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userId", user.getId());
        return "foradmin";
    }


    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model, @AuthenticationPrincipal User user) {

        if (user != null) {
            model.addAttribute("user", user);
            Car car = carMapper.toCar(carService.findById(id));
            model.addAttribute("car", car);
            model.addAttribute("title",
                    "Подробная информация об автомобиле Tesla " + car.getBody().getName() + " " + car.getEquipment().getName());

            return "site/car-details";
        }

        model.addAttribute("user", null);
        Car car = carMapper.toCar(carService.findById(id));
        model.addAttribute("car", car);
        model.addAttribute("title",
                "Подробная информация об автомобиле Tesla " + car.getBody().getName() + " " + car.getEquipment().getName());
        return "site/car-details";
    }
}
