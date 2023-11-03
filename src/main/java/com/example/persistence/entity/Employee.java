package com.example.persistence.entity;

import com.example.persistence.projection.EmployeeLocationDTO2;
import jakarta.persistence.*;
import lombok.Data;

@NamedNativeQuery(
        name = "getEmployeeLocationDTONamedQuery",
        query = "SELECT " +
                " E.NAME AS name," +
                " E.PHONE_NUMBER AS phoneNumber," +
                " A.STREET AS street" +
                " FROM EMPLOYEE E" +
                " INNER JOIN ADDRESS A ON A.ID = E.ADDRESS_ID" +
                " WHERE E.ID = :id",
        resultSetMapping = "EmployeeDTO2ResultSetMapping")
@SqlResultSetMapping(
        name = "EmployeeDTO2ResultSetMapping",
        classes = @ConstructorResult(
                targetClass = EmployeeLocationDTO2.class,
                columns = {
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "phone_number", type = String.class),
                        @ColumnResult(name = "street", type = String.class)
                }
        )
)
@Data
public @Entity class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;

    private long addressId;
}
