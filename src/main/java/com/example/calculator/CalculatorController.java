package com.example.calculator;

import org.springframework.web.bind.annotation.*;

// presentation
@RestController
@RequestMapping("/api")

public class CalculatorController {

    private CalculatorServiceInterface service;

    public CalculatorController(CalculatorServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Double add(@RequestParam Double x, @RequestParam Double y) {
        return service.add(x, y);
    }

    @GetMapping("/subtract")
    public Double subtract(@RequestParam Double x, @RequestParam Double y) {
        return service.subtract(x, y);
    }

    @GetMapping("/multiply")
    public Double multiply(@RequestParam Double x, @RequestParam Double y) {
        return service.multiply(x, y);
    }

    @GetMapping("/divide")
    public Double divide(@RequestParam Double x, @RequestParam Double y) {
        return service.divide(x, y);
    }

    @GetMapping("/expression")
    public Double express(@RequestParam String expression) {
        return service.express(expression);
    }

}
