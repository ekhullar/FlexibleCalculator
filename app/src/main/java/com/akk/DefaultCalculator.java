package com.akk;

public class DefaultCalculator implements Calculator{
    
    @Override
    public double calculate(Operation operation, double var1, double var2) {
        return operation.apply(var1, var2);
    }

}
