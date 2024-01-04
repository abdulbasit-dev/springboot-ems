package com.basitdev.ems.controllers.web;

import com.basitdev.ems.models.Employee;
import com.basitdev.ems.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller("webEmployeeController")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/create";
    }

    @PostMapping("/save")
    public String store(Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable UUID id){
        var employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employees/edit";
    }

    @GetMapping("/{id}/delete")
    public String destroy(@PathVariable UUID id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
