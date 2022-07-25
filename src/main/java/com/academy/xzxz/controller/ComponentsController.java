package com.academy.xzxz.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
@PreAuthorize(value = "hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class ComponentsController {

    @GetMapping()
    public String components() {
        return "components";
    }
}
