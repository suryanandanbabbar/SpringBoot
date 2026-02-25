package com.crud.springBootDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository empres;

    @PostMapping("/save")
    public String saveEmp(@RequestBody Employee emp) {
        empres.save(emp);
        return "Saved Successfully";
    }

    @PutMapping("/update/{id}")
    public String updateEmp(@RequestBody Employee emp) {
        empres.save(emp);
        return "Update Successfully";
    }

    @GetMapping("/get")
    public List<Employee> getAll() {
        return this.empres.findAll();
    }

}
