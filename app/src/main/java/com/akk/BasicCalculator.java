package com.akk;

public class BasicCalculator implements Calculator {

    @Override
    public double calculate(Operation operation, double var1, double var2) {
        switch (operation) {
            case ADD:
                return var1 + var2;
            case SUBTRACT:
                return var1 - var2;
            case MULTIPLY:
                return var1 * var2;
            case DIVIDE:
                return var1 / var2;
            default:
                throw new UnsupportedOperationException("Operation not supported");
        }
    }



}
