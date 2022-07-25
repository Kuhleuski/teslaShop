package com.academy.xzxz.controller;


import com.academy.xzxz.service.dto.WheelDto;
import com.academy.xzxz.service.interfaces.WheelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wheel")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class WheelController {


    private final WheelService wheelService;

    @GetMapping()
    public String allWheels(Model model) {
        model.addAttribute("wheelsList", wheelService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "wheel/wheel-list";
    }

    @PostMapping("/delete-wheel={id}")
    public String deleteWheelPost(@PathVariable(value = "id") int id) {
        wheelService.deleteById(id);
        return "redirect:/wheel";
    }


    @GetMapping("/create-new-wheel")
    public String newWheel(Model model) {
        model.addAttribute("title",
                "Создать новые колёса");
        return "wheel/create-new-wheel";
    }

    @PostMapping("/create-new-wheel")
    public String newWheelPost(@RequestParam String radius,
                                @RequestParam String type,
                                @RequestParam double price) {
        wheelService.createNewWheel(radius,type,price);
        return "redirect:/wheel";
    }

    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("wheel", wheelService.findById(id));
        model.addAttribute("title",
                "Подробная информация о колесе " + wheelService.findById(id).getRadius());
        return "wheel/wheel-details";
    }

    @GetMapping("/update-wheel={id}")
    public String wheelUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("wheel", wheelService.findById(id));
        model.addAttribute("title",
                "Редактировать колесо " + wheelService.findById(id).getRadius());
        return "wheel/update-wheel";
    }

    @PostMapping("/update-wheel={id}")
    public String wheelPostUpdate(@PathVariable(value = "id") int id, @RequestParam String radius, @RequestParam String type, @RequestParam double price) {

        WheelDto wheelDto = wheelService.findById(id);
        wheelDto.setRadius(radius);
        wheelDto.setType(type);
        wheelDto.setPrice(price);
        wheelService.updateWheel(wheelDto);
        return "redirect:/wheel";
    }
}
