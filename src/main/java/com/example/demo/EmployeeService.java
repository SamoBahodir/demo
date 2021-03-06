package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmoloyeeRepository emoloyeeRepository;

    public EmployeeService(EmoloyeeRepository emoloyeeRepository) {
        this.emoloyeeRepository = emoloyeeRepository;
    }

    public Employee save(Employee employee) {
        return emoloyeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return emoloyeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return emoloyeeRepository.findById(id).get();
    }

    public List<Employee> findByName(String name) {
        return emoloyeeRepository.findByName(name);
    }

    public List<Employee> findByNameAndLastName(String name, String lastName) {
        return emoloyeeRepository.findByNameAndLastName(name, lastName);
    }

    public List<Employee> findByNameStartsWith(String name) {
        return emoloyeeRepository.findByNameStartsWith(name);
    }

    public List<Employee> findByNameEndingWith(String name) {
        return emoloyeeRepository.findByNameEndingWith(name);
    }

    public void delete1(Long id) {
        Employee employee = emoloyeeRepository.getById(id);
        emoloyeeRepository.delete(employee);
    }

    public List<Employee> between(Long start, Long end) {
        return emoloyeeRepository.findByIdBetween(start, end);
    }

    @Scheduled(fixedRate = 5000L)
    public Employee saveCron() {
        Employee employee = new Employee();
        employee.setName("Mannob");
        employee.setLastName("Mannobov");
        return emoloyeeRepository.save(employee);
    }

}
