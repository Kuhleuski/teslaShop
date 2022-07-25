package com.academy.xzxz.controller;


import com.academy.xzxz.service.interfaces.BatteryService;
import com.academy.xzxz.service.interfaces.BodyService;
import com.academy.xzxz.service.interfaces.EngineService;
import com.academy.xzxz.service.interfaces.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/equipment")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final BatteryService batteryService;
    private final EngineService engineService;
    private final BodyService bodyService;

    @GetMapping()
    public String equipmentList(Model model) {
        model.addAttribute("equipmentList", equipmentService.findAll());
        model.addAttribute("message", "Склад пустой");
        return "equipment/equipment-list";
    }



    @PostMapping("/delete-equipment={id}")
    public String deleteEquipmentPost(@PathVariable(value = "id") int id) {
        equipmentService.deleteById(id);
        return "redirect:/equipment";
    }

    @GetMapping("/create-new-equipment")
    public String newEquipment(Model model) {
        model.addAttribute("allEngines", engineService.findAll());
        model.addAttribute("allBattery", batteryService.findAll());
        return "equipment/create-new-equipment";
    }

    @GetMapping("/for")
    public String create2( Model model) {
        model.addAttribute("bodyList", bodyService.findAll());
        model.addAttribute("title",
                "Создать комплектацию");
        return "equipment/for";
    }

    @GetMapping("/create={id}")
    public String create(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("allBattery", batteryService.findAll());
        model.addAttribute("engines", engineService.findEnginesForBody(id));
        model.addAttribute("body", bodyService.findById(id));
        model.addAttribute("title", "Создать комплектацию для кузова " + bodyService.findById(id).getName());
        return "equipment/for-body";
    }

    @PostMapping("/create={id}")
    public String createPost(@RequestParam String name,
                             @PathVariable(value = "id") int id,
                                   @RequestParam int engineId,
                                   @RequestParam int bodyId,
                                   @RequestParam double accelerate,
                                   @RequestParam int maxSpeed,
                                   @RequestParam int batteryId) {
        equipmentService.createNewEquipment(name, engineId, batteryId,bodyId, accelerate, maxSpeed);
        return "redirect:/equipment";
    }


    @GetMapping("/create-from-car={id}")
    public String createEquipmentFromCreateCarPage(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("allBattery", batteryService.findAll());
        model.addAttribute("engines", engineService.findEnginesForBody(id));
        model.addAttribute("body", bodyService.findById(id));
        model.addAttribute("title", "Создать комплектацию для кузова " + bodyService.findById(id).getName());
        return "equipment/for-body";
    }

    @PostMapping("/create-from-car={id}")
    public String createEquipmentFromCarPost(@RequestParam String name,
                             @PathVariable(value = "id") int id,
                             @RequestParam int engineId,
                             @RequestParam int bodyId,
                             @RequestParam double accelerate,
                             @RequestParam int maxSpeed,
                             @RequestParam int batteryId) {
        equipmentService.createNewEquipment(name, engineId, batteryId,bodyId, accelerate, maxSpeed);
        return "redirect:/car/create={id}";
    }

    @PostMapping("/create-new-equipment")
    public String newEquipmentPost(@RequestParam String name,
                                   @RequestParam int engineId,
                                   @RequestParam int bodyId,
                                   @RequestParam double accelerate,
                                   @RequestParam int maxSpeed,
                                   @RequestParam int batteryId) {
        equipmentService.createNewEquipment(name, engineId, batteryId,bodyId, accelerate, maxSpeed);
        return "redirect:/equipment";
    }

    @GetMapping("/show-details={id}")
    public String showDetails(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("equipment", equipmentService.findById(id));
        model.addAttribute("title",
                "Подробная информация о комплектации " + equipmentService.findById(id).getName());
        return "equipment/equipment-details";
    }

    @GetMapping("/update-equipment={id}")
    public String equipmentUpdate(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("equipment", equipmentService.findById(id));
        model.addAttribute("allBattery", batteryService.findAll());
        model.addAttribute("allEngines", engineService.findAll());
        model.addAttribute("title",
                "Редактировать комплектацию " + equipmentService.findById(id).getName());

        return "equipment/update-equipment";
    }

    @PostMapping("/update-equipment={id}")
    public String equipmentPostUpdate(@PathVariable(value = "id") int id,
                                      @RequestParam String name,
                                      @RequestParam int engineId,
                                      @RequestParam int bodyId,
                                      @RequestParam double accelerate,
                                      @RequestParam int maxSpeed,
                                      @RequestParam int batteryId) {
        equipmentService.updateEquipment(id,name,engineId,batteryId, bodyId, accelerate,maxSpeed);
        return "redirect:/equipment";
    }

}
