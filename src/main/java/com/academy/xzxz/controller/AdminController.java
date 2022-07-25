package com.academy.xzxz.controller;


import com.academy.xzxz.model.User;
import com.academy.xzxz.service.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class AdminController {


    private final EquipmentService equipmentService;
    private final BatteryService batteryService;
    private final EngineService engineService;
    private final BodyService bodyService;
    private final ColorService colorService;
    private final WheelService wheelService;
    private final CarService  carService;


    @GetMapping
    public String admin(@AuthenticationPrincipal User user, Model model){
        if (user != null){
            model.addAttribute("username", user.getUsername());
            model.addAttribute("userId", user.getId());
            model.addAttribute("userRole", user.getRoles());

            model.addAttribute("countEngines", engineService.findAll().size());
            model.addAttribute("countBody", bodyService.findAll().size());
            model.addAttribute("countBattery", batteryService.findAll().size());
            model.addAttribute("countEquipment", equipmentService.findAll().size());
            model.addAttribute("countColors", colorService.findAll().size());
            model.addAttribute("countWheels", wheelService.findAll().size());
            model.addAttribute("countCars", carService.findAll().size());

            return "foradmin";
        }
        model.addAttribute("username","undefined");
        model.addAttribute("userId","none");
        model.addAttribute("userRole","GUEST");
        return "foradmin";
    }

}
