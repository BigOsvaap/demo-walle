package com.encora.demowalle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/demo")
    public ResponseEntity<DemoDTO> demo() {
        return new ResponseEntity<>(new DemoDTO("Hello!"), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

}

