package com.walmart.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class TestController {

    @GetMapping
    public String getProducts() {
        return "Product List from Product Service";
    }
}
