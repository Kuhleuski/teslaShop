package com.academy.xzxz.controller;


import com.academy.xzxz.service.dto.BodyDto;
import com.academy.xzxz.service.interfaces.BodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/body")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class BodyController {

    private final BodyService bodyService;

    @GetMapping()
    public String bodyList(Model model) {
        model.addAttribute("bodyList", bodyService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "body/body-list";
    }

    @PostMapping("/delete-body={id}")
    public String deleteBodyPost(@PathVariable(value = "id") int id) {
        bodyService.deleteById(id);
        return "redirect:/body";
    }

    @GetMapping("/create-new-body")
    public String newBody(Model model) {
        model.addAttribute("title",
                "Создать новый кузов для автомобиля Tesla");
        return "body/create-new-body";
    }

    @PostMapping("/create-new-body")
    public String newBodyPost(@RequestParam String name,
                              @RequestParam String type,
                              @RequestParam int numberOfSeats,
                              @RequestParam double weight,
                              @RequestParam double width,
                              @RequestParam double height,
                              @RequestParam double length,
                              @RequestParam int trunk,
                              @RequestParam double wheelBase,
                              @RequestParam double price) {
        bodyService.createNewBody(name, type, numberOfSeats, weight,
                width, height, length, trunk, wheelBase, price);
        return "redirect:/body";
    }

    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("body", bodyService.findById(id));
        return "body/body-details";
    }


    @GetMapping("/update-body={id}")
    public String bodyUpdate(@PathVariable(value = "id") int id, Model model) {
        BodyDto bodyDto = bodyService.findById(id);
        model.addAttribute("body", bodyDto);
        model.addAttribute("title",
                "Редактировать кузов " + bodyDto.getName() + " "
                        + bodyDto.getType());
        return "body/update-body";
    }

    @PostMapping("/update-body={id}")
    public String bodyPostUpdate(@PathVariable(value = "id") int id,
                                 @RequestParam String name,
                                 @RequestParam String type,
                                 @RequestParam int numberOfSeats,
                                 @RequestParam double weight,
                                 @RequestParam double width,
                                 @RequestParam double height,
                                 @RequestParam double length,
                                 @RequestParam int trunk,
                                 @RequestParam double wheelBase,
                                 @RequestParam double price) {

        BodyDto bodyDto = bodyService.findById(id);
        bodyDto.setName(name);
        bodyDto.setType(type);
        bodyDto.setNumberOfSeats(numberOfSeats);
        bodyDto.setWeight(weight);
        bodyDto.setWidth(width);
        bodyDto.setHeight(height);
        bodyDto.setLength(length);
        bodyDto.setTrunk(trunk);
        bodyDto.setWheelBase(wheelBase);
        bodyDto.setPrice(price);
        bodyService.updateBody(bodyDto);
        return "redirect:/body";
    }
}
