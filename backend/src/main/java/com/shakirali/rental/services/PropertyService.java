package com.shakirali.rental.services;

import com.shakirali.rental.entity.Property;
import com.shakirali.rental.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Property addProperty(Property property) {
        validateProperty(property);
        return propertyRepository.save(property);
    }

    public Property fetchProperty(Long id, String name) {
        return propertyRepository.findByIdAndName(id, name).orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    private void validateProperty(Property property) {
        if (property.getMonthlyRent() <= 0) {
            throw new IllegalArgumentException("Monthly rent must be greater than zero.");
        }
        if (property.getDueDay() < 1 || property.getDueDay() > 31) {
            throw new IllegalArgumentException("Due day must be between 1 and 31.");
        }
    }


}
