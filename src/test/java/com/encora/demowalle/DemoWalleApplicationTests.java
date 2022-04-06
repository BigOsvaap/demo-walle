package com.encora.demowalle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoWalleApplicationTests extends PostgresDbTestContainer{

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository repository;

    @BeforeEach
    void setup() {
        repository.deleteAll();
    }

    @Test
    void correctMessage(){
        DemoDTO body = restTemplate.getForObject("/api/demo", DemoDTO.class);
        Assertions.assertEquals(body.getMessage(), "Hello!");
    }

    @Test
    void testingEmptyEmployees(){
        Employee[] employees = restTemplate.getForObject("/api/employees", Employee[].class);
        Assertions.assertEquals(employees.length, 0);
    }

    @Test
    void testingNotEmptyEmployees(){
        repository.save(new Employee(null, "Oswaldo"));
        repository.save(new Employee(null, "Juan"));

        Employee[] employees = restTemplate.getForObject("/api/employees", Employee[].class);
        Assertions.assertEquals(employees.length, 2);
    }

}
