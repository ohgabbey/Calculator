package com.example.calculator;

import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class EngineCalculatorService implements CalculatorServiceInterface {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String answer = "0", expVal, expToEvaluate = "0";
    Integer i = 0;

    @Override
    public Double add(Double x, Double y) {
        expToEvaluate = x + "+" + y;
        try {
            answer = String.valueOf(engine.eval(expToEvaluate));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.valueOf(answer);
    }

    @Override
    public Double subtract(Double x, Double y) {
        expToEvaluate = x + "-" + y;
        try {
            answer = String.valueOf(engine.eval(expToEvaluate));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.valueOf(answer);
    }

    @Override
    public Double multiply(Double x, Double y) {
        expToEvaluate = x + "*" + y;
        try {
            answer = String.valueOf(engine.eval(expToEvaluate));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.valueOf(answer);
    }

    @Override
    public Double divide(Double x, Double y) {
        expToEvaluate = x + "/" + y;
        try {
            answer = String.valueOf(engine.eval(expToEvaluate));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.valueOf(answer);
    }

    @Override
    public Double express(String expression) {
        expToEvaluate = expression;

        String answer = null;
        try {
            answer = String.valueOf(engine.eval(expToEvaluate));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return Double.valueOf(answer);
    }

}
