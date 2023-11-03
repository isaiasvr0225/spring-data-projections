package com.example.persistence.repository;

import com.example.persistence.entity.Employee;
import com.example.persistence.projection.EmployeeFullLocation;
import com.example.persistence.projection.EmployeeInfo;
import com.example.persistence.projection.EmployeeLocationDTO2;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Using closed projections with a closed interface
    @Query(value = "SELECT " +
                    " E.NAME AS name," +
                    " E.PHONE_NUMBER AS phoneNumber," +
                    " A.STREET AS street" +
                    " FROM EMPLOYEE E" +
                    " INNER JOIN ADDRESS A ON A.ID = E.ADDRESS_ID" +
                    " WHERE E.ID = :id", nativeQuery = true)
    EmployeeInfo getEmployeeInfo(@Param("id") Long employeeId);


    // Using opened projections with a opened interface
    @Query(value = "SELECT " +
            " E.NAME AS name," +
            " E.PHONE_NUMBER AS phoneNumber," +
            " A.STREET AS street" +
            " FROM EMPLOYEE E" +
            " INNER JOIN ADDRESS A ON A.ID = E.ADDRESS_ID" +
            " WHERE E.ID = :id", nativeQuery = true)
    EmployeeFullLocation getEmployeeFullLocation(@Param("id") Long employeeId);


    // Using class based projection with java record
    @Query(value = "SELECT " +
            " E.NAME AS name," +
            " E.PHONE_NUMBER AS phoneNumber," +
            " A.STREET AS street" +
            " FROM EMPLOYEE E" +
            " INNER JOIN ADDRESS A ON A.ID = E.ADDRESS_ID" +
            " WHERE E.ID = :id", nativeQuery = true)
    Tuple getEmployeeLocationDTO(@Param("id") Long employeeId);


    // Using named native query with java record
    @Query(name = "getEmployeeLocationDTONamedQuery", nativeQuery = true)
    EmployeeLocationDTO2 getEmployeeLocationDTO2(@Param("id") Long employeeId);


    // Using generics to get the response dinamically
    @Query(value = "SELECT " +
            " E.NAME AS name," +
            " E.PHONE_NUMBER AS phoneNumber," +
            " A.STREET AS street" +
            " FROM EMPLOYEE E" +
            " INNER JOIN ADDRESS A ON A.ID = E.ADDRESS_ID" +
            " WHERE E.ID = :id", nativeQuery = true)
    <T> T getEmployeeLocationDinamically(@Param("id") Long employeeId, Class<T> projectionType);
}
