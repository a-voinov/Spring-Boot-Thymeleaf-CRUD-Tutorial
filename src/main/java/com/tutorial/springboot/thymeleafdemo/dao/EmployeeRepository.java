package com.tutorial.springboot.thymeleafdemo.dao;

import com.tutorial.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it...
}
