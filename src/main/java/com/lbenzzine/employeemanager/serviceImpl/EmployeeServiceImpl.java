package com.lbenzzine.employeemanager.serviceImpl;

import com.lbenzzine.employeemanager.exception.EmployeeNotFoundException;
import com.lbenzzine.employeemanager.model.Employee;
import com.lbenzzine.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee e){
        e.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(e);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee e){
        return employeeRepo.save(e);
    }

    public void deleteEmployeeById(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                           .orElseThrow(() ->new EmployeeNotFoundException("Employee by id : " + id + "not found"));
    }

}
