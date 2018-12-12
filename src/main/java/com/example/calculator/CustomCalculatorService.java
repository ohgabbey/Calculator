package com.example.calculator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class CustomCalculatorService implements CalculatorServiceInterface{
    @Override
    public Double add(Double x, Double y) {
        return (x + y);
    }

    @Override
    public Double subtract(Double x, Double y) {
        return (x - y);
    }

    @Override
    public Double multiply(Double x, Double y) {
        return (x * y);
    }

    @Override
    public Double divide(Double x, Double y) {
        return (x / y);
    }

    @Override
    public Double express(String expression) {
        List<String> expList = new ArrayList<>();
        List<String> operatorList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        int counter = 0, counterOp = 0;
        String value, next_val;
        Double num1 = 0.0, num2 = 0.0, total = 0.0;

        StringBuilder strBuilder= new StringBuilder();

        while (counter < expression.length()) {
            value = expression.substring(counter, counter + 1);
            expList.add(value);
            counter++;
        }

        counter = 0;
        while(counter < expList.size()){
            value = expList.get(counter);

            if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")){
                operatorList.add(value);
                counter++;
            } else{
                strBuilder.append(value);
                counter++;
                if(counter < expList.size()) {
                    next_val = expList.get(counter);
                    while (!next_val.equals("+") && !next_val.equals("-") && !next_val.equals("*") && !next_val.equals("/")) {
                        strBuilder.append(next_val);
                        if (counter < expList.size()) {
                            counter++;
                            next_val = expList.get(counter);
                        }
                    }
                }
                valueList.add(String.valueOf(strBuilder));
                strBuilder.setLength(0);
            }
        }

        counter = 0;
        while(counter < valueList.size()){

            if(counter == 0) {
                num1 = Double.valueOf(valueList.get(counter));
                num2 = Double.valueOf(valueList.get(counter + 1));
            } else{
                num1 = total;
                num2 = Double.valueOf(valueList.get(counter));
            }

            switch (operatorList.get(counterOp)) {
                case "+":
                    total = add(num1, num2);
                    break;
                case "-":
                    total = subtract(num1, num2);
                    break;
                case "*":
                    total = multiply(num1, num2);
                    break;
                case "/":
                    total = divide(num1, num2);
                    break;
            }

            counterOp++;
            if(counter==0){
                counter = counter + 2;
            } else{
                counter++;
            }
        }

        return total;
    }

}
