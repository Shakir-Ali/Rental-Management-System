package com.shakirali.rental.services;

import com.shakirali.rental.entity.Property;
import com.shakirali.rental.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public void addProperty() {
        Property property = new Property();
        property.setName("Underground");
        property.setType("SHOPS");
        property.setMonthlyRent(40000);
        property.setDueDay(1);

        propertyRepository.save(property);
    }
}
