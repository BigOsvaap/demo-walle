package com.encora.demowalle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoWalleApplicationTests extends PostgresDbTestContainer{

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void correctMessage(){
        DemoDTO body = restTemplate.getForObject("/api", DemoDTO.class);
        Assertions.assertEquals(body.getMessage(), "Hello!");
    }

}
