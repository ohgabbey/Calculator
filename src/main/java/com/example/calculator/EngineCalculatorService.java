package com.example.calculator;

import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class EngineCalculatorService implements CalculatorServiceInterface{
    private ScriptEngineManager mgr = new ScriptEngineManager();
    private ScriptEngine engine = mgr.getEngineByName("JavaScript");
    private String answer = "0", expToEvaluate = "0";

    @Override
    public Double add(Double x, Double y) {
            expToEvaluate = x + "+" + y;
            evaluateExpression();
        return Double.valueOf(answer);
    }

    @Override
    public Double subtract(Double x, Double y) {
        expToEvaluate = x + "-" + y;
        evaluateExpression();
        return Double.valueOf(answer);
    }

    @Override
    public Double multiply(Double x, Double y) {
        expToEvaluate = x + "*" + y;
        evaluateExpression();
        return Double.valueOf(answer);
    }

    @Override
    public Double divide(Double x, Double y) {
        expToEvaluate = x + "/" + y;
        evaluateExpression();
        return Double.valueOf(answer);
    }

    @Override
    public Double express(String expression) {
        expToEvaluate = expression;
        evaluateExpression();
        return Double.valueOf(answer);
    }

    private void evaluateExpression() {
        try {
            answer = String.valueOf(engine.eval(expToEvaluate));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

}
