package com.akk;

import java.util.function.BinaryOperator;

public enum Operation {

    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private final BinaryOperator<Double> operation;

    Operation(String symbol, BinaryOperator<Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public double apply(double a, double b) {
        return operation.apply(a, b);
    }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid symbol: " + symbol);
    }
}

