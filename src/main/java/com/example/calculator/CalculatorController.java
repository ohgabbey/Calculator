package com.example.calculator;

import org.springframework.web.bind.annotation.*;


// presentation
@RestController
@RequestMapping("/api")
public class CalculatorController{

    private String response;
    private CalculatorServiceInterface service;
    public CalculatorController(CalculatorServiceInterface service) {
        this.service = service;
    }

    private boolean checkParameters(String x, String y){
        try {
            Double.parseDouble(x);
            Double.parseDouble(y);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    @GetMapping("/add")
    public String add(@RequestParam String x, @RequestParam String y){
        response = (checkParameters(x, y)) ? String.valueOf(service.add(Double.valueOf(x),Double.valueOf(y))):"Please enter numerical values for both x and y.";
        return response;
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam String x, @RequestParam String y){
        response = (checkParameters(x, y)) ? String.valueOf(service.subtract(Double.valueOf(x),Double.valueOf(y))):"Please enter numerical values for both x and y.";
        return response;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam String x, @RequestParam String y){
        response = (checkParameters(x, y)) ? String.valueOf(service.multiply(Double.valueOf(x),Double.valueOf(y))):"Please enter numerical values for both x and y.";
        return response;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam String x, @RequestParam String y){
        response = (checkParameters(x, y)) ? "true":"Please enter numerical values for both x and y.";

        if(!y.equals("0") && response.equals("true")){
            response = String.valueOf(service.divide(Double.valueOf(x),Double.valueOf(y)));
        } else if(y.equals("0")){
            response = "Division by zero is not allowed.";
        }

        return response;
    }

    @GetMapping("/expression")
    public Double express(@RequestParam String expression) {
        return service.express(expression);
    }

}
