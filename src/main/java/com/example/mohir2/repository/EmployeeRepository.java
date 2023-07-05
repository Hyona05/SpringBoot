package com.example.mohir2.repository;

import com.example.mohir2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.name = :name")
    List<Employee> findAll(@Param("name")String name);
    List<Employee> findAllByName(String name);
}
