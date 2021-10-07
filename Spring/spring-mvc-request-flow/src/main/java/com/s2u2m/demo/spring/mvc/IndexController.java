package com.s2u2m.demo.spring.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/request-flow")
public class IndexController {

    private ApplicationContext context;
    public IndexController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping(value = "/")
    public Collection<DomainItem> index() {
        return List.of(DomainItem.builder().name("").build());
    }

    @GetMapping(value = "/", params = "type=all")
    public Collection<DomainItem> index2() {
        return List.of(DomainItem.builder().name("all").build());
    }

    @PostMapping(value = "/")
    public DomainItem pingPong(@RequestBody CustomRequest request) {
        return DomainItem.builder().name(request.getName()).build();
    }

    @PostMapping(value = "/price")
    public Money price(@RequestHeader Money money) {
        return money;
    }

    @GetMapping("/items/{id}")
    public DomainItem getDomainItem(@PathVariable("id") DomainItem id) {
        return id;
    }

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<String> handleMissingRequestValueException(MissingRequestValueException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
