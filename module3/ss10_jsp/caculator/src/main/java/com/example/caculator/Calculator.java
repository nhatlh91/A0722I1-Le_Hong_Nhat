package com.example.caculator;

public class Calculator {
    private float first;
    private float second;
    private char operand;

    public Calculator(float first, float second, char operand) {
        this.first = first;
        this.second = second;
        this.operand = operand;
    }

    public String calculate(){
        try {
            float result = 0;
            switch(operand) {
                case '+':
                    result = first + second;
                    break;
                case '-':
                    result = first - second;
                    break;
                case '*':
                    result = first * second;
                    break;
                case ':':
                    result = first / second;
            }
            return first + " " + operand + " " + second + " = " + result;
        }
        catch(Exception e) {
            return "Error operand";
        }
    }
}
