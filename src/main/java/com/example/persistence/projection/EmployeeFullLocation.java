package com.example.persistence.projection;

import org.springframework.beans.factory.annotation.Value;

// Open projection with open interface
public interface EmployeeFullLocation {

    @Value("#{target.name + '' + target.phoneNumber + '' + target.street}")
    String getFullLocation();
}
