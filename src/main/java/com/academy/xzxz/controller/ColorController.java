package com.academy.xzxz.controller;


import com.academy.xzxz.service.dto.ColorDto;
import com.academy.xzxz.service.interfaces.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/color")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @GetMapping()
    public String colorList(Model model) {
        model.addAttribute("colorList", colorService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "color/color-list";
    }

    @PostMapping("/delete-color={id}")
    public String deleteColorPost(@PathVariable(value = "id") int id) {
        colorService.deleteById(id);
        return "redirect:/color";
    }

    @GetMapping("/create-new-color")
    public String newColor(Model model) {
        model.addAttribute("title",
                "Создать новый цвет");
        return "color/create-new-color";
    }

    @PostMapping("/create-new-color")
    public String newColorPost(@RequestParam String name,
                                @RequestParam double price) {
        colorService.createNewColor(name,price);
        return "redirect:/color";
    }

    @GetMapping("/update-color={id}")
    public String colorUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("color", colorService.findById(id));
        model.addAttribute("title",
                "Редактировать цвет " + colorService.findById(id).getName());
        return "color/update-color";
    }

    @PostMapping("/update-color={id}")
    public String colorPostUpdate(@PathVariable(value = "id") int id, @RequestParam String name, @RequestParam double price) {

        ColorDto colorDto = colorService.findById(id);
        colorDto.setName(name);

        colorDto.setPrice(price);
        colorService.updateColor(colorDto);
        return "redirect:/color";
    }
}
