package com.reightvoid.jja.controller;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reightvoid.jja.core.AdminModelDefinition;
import com.reightvoid.jja.core.AdminRegistry;

@RestController 
@RequestMapping("/admin/api")
public class AdminController {
    private final AdminRegistry registry;
    public AdminController(AdminRegistry registry){
        this.registry = registry;
    }
    @GetMapping("/models")
    public Collection<AdminModelDefinition> get()
    {
        return registry.getAll();
    } 
}
