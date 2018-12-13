package com.example.calculator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        int generalCounter = 0, operatorCounter = 0;
        Double total = 0.0;
        StringBuilder strBuilder= new StringBuilder();

        convertToList(expression, expList, generalCounter);

        generalCounter = 0;
        separateList(expList, operatorList, valueList, generalCounter, strBuilder);

        generalCounter = 0;
        total = evaluateExpression(operatorList, valueList, generalCounter, operatorCounter, total);

        return total;
    }

    private Double evaluateExpression(List<String> operatorList, List<String> valueList, int generalCounter, int operatorCounter, Double total) {
        Double num1;
        Double num2;
        while(generalCounter < valueList.size()){

            if(generalCounter == 0) {
                num1 = Double.valueOf(valueList.get(generalCounter));
                num2 = Double.valueOf(valueList.get(generalCounter + 1));
            } else{
                num1 = total;
                num2 = Double.valueOf(valueList.get(generalCounter));
            }

            switch (operatorList.get(operatorCounter)) {
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

            operatorCounter++;
            if(generalCounter==0){
                generalCounter = generalCounter + 2;
            } else{
                generalCounter++;
            }
        }
        return total;
    }

    private void separateList(List<String> expList, List<String> operatorList, List<String> valueList, int generalCounter, StringBuilder strBuilder) {
        String listValue1;
        String listValue2;
        while(generalCounter < expList.size()){
            listValue1 = expList.get(generalCounter);

            if(listValue1.equals("+") || listValue1.equals("-") || listValue1.equals("*") || listValue1.equals("/")){
                operatorList.add(listValue1);
                generalCounter++;
            } else{
                strBuilder.append(listValue1);
                generalCounter++;
                if(generalCounter < expList.size()) {
                    listValue2 = expList.get(generalCounter);
                    while (!listValue2.equals("+") && !listValue2.equals("-") && !listValue2.equals("*") && !listValue2.equals("/")) {
                        strBuilder.append(listValue2);
                        if (generalCounter < expList.size()) {
                            generalCounter++;
                            listValue2 = expList.get(generalCounter);
                        }
                    }
                }
                valueList.add(String.valueOf(strBuilder));
                strBuilder.setLength(0);
            }
        }
    }

    private void convertToList(String expression, List<String> expList, int counter) {
        String value;
        while (counter < expression.length()) {
            value = expression.substring(counter, counter + 1);
            expList.add(value);
            counter++;
        }
    }

}
