package com.akk;



public class CalculatorApp {

    public static void main(String[] args) {

        Calculator calc = new BasicCalculator();
        
        CalculatorConsole calculator = new CalculatorConsole(calc);
        
        calculator.run();
       
    }

}
