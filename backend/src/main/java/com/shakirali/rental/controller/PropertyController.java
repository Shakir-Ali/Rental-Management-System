package com.shakirali.rental.controller;

import com.shakirali.rental.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/addProperty")
    public String addProperty() {
        propertyService.addProperty();
        return "Add Property Endpoint";
    }
}
