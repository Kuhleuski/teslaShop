package com.academy.xzxz.controller;


import com.academy.xzxz.service.interfaces.BodyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/body-type")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class BodyTypeController {

    private final BodyTypeService bodyTypeService;

    @GetMapping()
    public String bodyTypeList(Model model) {
        model.addAttribute("bodyTypeList", bodyTypeService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "body-type/body-type-list";
    }

    @PostMapping("/delete-body-type={id}")
    public String deleteBodyTypePost(@PathVariable(value = "id") int id) {
        bodyTypeService.deleteById(id);
        return "redirect:/body-type";
    }

    @PostMapping
    public String newBodyTypePost(@RequestParam String name) {
        bodyTypeService.createNewBodyType(name);
        return "redirect:/body-type";
    }

    @GetMapping("/update-body-type={id}")
    public String bodyTypeUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("bodyType", bodyTypeService.findById(id));
        return "body-type/body-type-update";
    }

    @PostMapping("/update-body-type={id}")
    public String bodyTypePostUpdate(@PathVariable(value = "id") int id, @RequestParam String name) {
        bodyTypeService.updateBodyType(id,name);
        return "redirect:/body-type";
    }
}
