package com.akk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultCalculatorTest {

    @Test
    public void testCalculate() {
        // Create a DefaultCalculator instance
        DefaultCalculator calculator = new DefaultCalculator();
            
        // Test addition
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3),0);
        
        // Test subtraction
        assertEquals(1, calculator.calculate(Operation.SUBTRACT, 3, 2),0);
        
        // Test multiplication
        assertEquals(6, calculator.calculate(Operation.MULTIPLY, 2, 3),0);
        
        // Test division
        assertEquals(3, calculator.calculate(Operation.DIVIDE, 6, 2),0);

        // Test division
        System.out.println(calculator.calculate(Operation.DIVIDE, 6, 0));
    }
}
