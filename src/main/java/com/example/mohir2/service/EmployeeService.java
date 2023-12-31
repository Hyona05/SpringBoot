package com.example.mohir2.service;

import com.example.mohir2.entity.Employee;
import com.example.mohir2.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public  void delete(Long id){
        employeeRepository.deleteById(id);
    }
    public  Employee findById(Long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return  null;
    }
    public List<Employee> findAll(String name){
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees;
    }
}
