package com.example.controller;

import com.example.persistence.projection.EmployeeFullLocation;
import com.example.persistence.projection.EmployeeInfo;
import com.example.persistence.projection.EmployeeLocationDTO;
import com.example.persistence.projection.EmployeeLocationDTO2;
import com.example.persistence.repository.EmployeeRepository;
import jakarta.persistence.Tuple;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/closed_projection/{id}")
    public EmployeeInfo getEmployeeInfo(@PathVariable("id") Long id) {
        return this.employeeRepository.getEmployeeInfo(id);
    }

    @GetMapping("/open_projection/{id}")
    public EmployeeFullLocation getEmployeeFullLocation(@PathVariable("id") Long id) {
        return this.employeeRepository.getEmployeeFullLocation(id);
    }

    @GetMapping("/class_based_projection/{id}")
    public EmployeeLocationDTO getEmployeeLocationDTO(@PathVariable("id") Long id) {
        Tuple employeeTuple = this.employeeRepository.getEmployeeLocationDTO(id);

        return new EmployeeLocationDTO(employeeTuple.get(0, String.class),
                                       employeeTuple.get(1, String.class),
                                       employeeTuple.get(2, String.class));
    }

    @GetMapping("/named_native_query/{id}")
    public EmployeeLocationDTO2 getEmployeeLocationDTO2(@PathVariable("id") Long id) {
        return this.employeeRepository.getEmployeeLocationDTO2(id);
    }

    @GetMapping("/dinamic_projection/{id}")
    public Object getEmployeeLocationDinamically(@PathVariable("id") Long id) {
        return this.employeeRepository.getEmployeeLocationDinamically(id, EmployeeInfo.class);
    }
}
