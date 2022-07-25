package com.academy.xzxz.controller;

import com.academy.xzxz.service.dto.EngineDto;
import com.academy.xzxz.service.interfaces.BodyService;
import com.academy.xzxz.service.interfaces.EngineService;
import com.academy.xzxz.service.mappers.BodyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/engine")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class EngineController {

    private final EngineService engineService;

    private final BodyService bodyService;
    private final BodyMapper bodyMapper;


    @GetMapping()
    public String engineList(Model model) {
        model.addAttribute("engines", engineService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "engine/engine-list";
    }

    @PostMapping("/delete-engine={id}")
    public String deleteEnginePost(@PathVariable(value = "id") int id) {
        engineService.deleteById(id);
        return "redirect:/engine";
    }


    @GetMapping("/create-new-engine")
    public String newEngine(Model model) {
        model.addAttribute("bodyList", bodyService.findAll());
        model.addAttribute("title",
                "Создать новый двигатель для Tesla");
        return "engine/create-new-engine";
    }

    @PostMapping("/create-new-engine")
    public String newEnginePost(@RequestParam String name,
                                @RequestParam int power,
                                @RequestParam int bodyId,
                                @RequestParam int torque,
                                @RequestParam String driveUnit,
                                @RequestParam double price) {



        engineService.createNewEngine(name,power,torque,driveUnit,bodyId,price);
        return "redirect:/engine";
    }


    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("engine", engineService.findById(id));
        model.addAttribute("title",
                "Подробная информация о двигателе " + engineService.findById(id).getName());
        return "engine/engine-details";
    }

    @GetMapping("/update-engine={id}")
    public String engineUpdate(@PathVariable(value = "id") int id, Model model) {
        EngineDto engineDto = engineService.findById(id);
        model.addAttribute("engine", engineDto);
        model.addAttribute("bodyList", bodyService.findAll());
        model.addAttribute("title",
                "Редактировать двигатель " + engineDto.getName() + " "
                                                        + engineDto.getPower()+" л/с");

        return "engine/update-engine";
    }

    @PostMapping("/update-engine={id}")
    public String enginePostUpdate(@PathVariable(value = "id") int id,
                                   @RequestParam String name,
                                   @RequestParam int power,
                                   @RequestParam int torque,
                                   @RequestParam int bodyId,
                                   @RequestParam String driveUnit,
                                   @RequestParam double price) {

        EngineDto engineDto = engineService.findById(id);
        engineDto.setName(name);
        engineDto.setPower(power);
        engineDto.setTorque(torque);
        engineDto.setBody(bodyMapper.toBody(bodyService.findById(bodyId)));
        engineDto.setDriveUnit(driveUnit);
        engineDto.setPrice(price);
        engineService.updateEngine(engineDto);
        return "redirect:/engine";
    }

}
