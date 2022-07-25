package com.academy.xzxz.controller;

import com.academy.xzxz.service.dto.BatteryDto;
import com.academy.xzxz.service.interfaces.BatteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/battery")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;

    @GetMapping()
    public String batteryList(Model model) {
        model.addAttribute("batteryList", batteryService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "battery/battery-list";
    }

    @GetMapping("/create-new-battery")
    public String newBattery(Model model) {
        model.addAttribute("title",
                "Создать новые батарею");
        return "battery/create-new-battery";
    }

        @PostMapping("/create-new-battery")
    public String newBatteryPost(@RequestParam String capacity, @RequestParam int reserve,
                                 @RequestParam boolean status,
                                  @RequestParam double price) {
        batteryService.createNewBattery(capacity,reserve, status,price);
        return "redirect:/battery";
    }

    @PostMapping("/delete-battery={id}")
    public String deleteBatteryPost(@PathVariable(value = "id") int id) {
        batteryService.deleteById(id);
        return "redirect:/battery";
    }

    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("battery", batteryService.findById(id));
        model.addAttribute("title",
                "Подробная информация о батарее" + batteryService.findById(id).getCapacity());
        return "battery/battery-details";
    }

    @GetMapping("/update-battery={id}")
    public String batteryUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("battery", batteryService.findById(id));

        model.addAttribute("title",
                "Редактировать батарею " + batteryService.findById(id).getCapacity());
        return "battery/update-battery";
    }

    @PostMapping("/update-battery={id}")
    public String batteryPostUpdate(@PathVariable(value = "id") int id,
                                    @RequestParam String capacity,
                                    @RequestParam int reserve,
                                    @RequestParam boolean status,
                                    @RequestParam double price) {

        BatteryDto batteryDto = batteryService.findById(id);
        batteryDto.setCapacity(capacity);
        batteryDto.setReserve(reserve);
        batteryDto.setStatus(status);
        batteryDto.setPrice(price);
        batteryService.updateBattery(batteryDto);
        return "redirect:/battery";
    }
}
