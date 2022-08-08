package com.example.keycloak.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import static org.apache.commons.lang3.RandomStringUtils.*;


@RestController
@RequestMapping(value = "/foos")
public class FooController {
    @GetMapping(value = "/{id}")
    public Foo findOne(@PathVariable Long id) {
        return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Foo {
        private long id;
        private String name;
    }
}
