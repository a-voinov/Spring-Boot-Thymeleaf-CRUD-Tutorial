package com.tutorial.springboot.thymeleafdemo.controller;

import com.tutorial.springboot.thymeleafdemo.entity.Employee;
import com.tutorial.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "/employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForAdd(@RequestParam("employeeId") int id,
                                 Model model){
        //get the employee from the service
        Employee employee = employeeService.findById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        //send over to our form
        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        //use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String saveEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        //use redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

}
