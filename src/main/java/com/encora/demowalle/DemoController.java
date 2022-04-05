package com.encora.demowalle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class DemoController {

    @GetMapping("/api")
    public ResponseEntity<DemoDTO> demo() {
        return new ResponseEntity<>(new DemoDTO("Hello!"), HttpStatus.OK);
    }



}

