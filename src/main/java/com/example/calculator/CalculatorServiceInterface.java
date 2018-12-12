package com.example.calculator;

public interface CalculatorServiceInterface {
    Double add(Double x, Double y);
    Double subtract(Double x, Double y);
    Double multiply(Double x, Double y);
    Double divide(Double x, Double y);
    Double express(String expression);
}
