package com.example.persistence.projection;

/**
 * Projection for {@link com.example.persistence.entity.Employee}
 */

// Closed projection using closed interface
public interface EmployeeInfo {
    String getName();

    String getPhoneNumber();

    String getStreet();
}