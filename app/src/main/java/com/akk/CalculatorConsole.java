package com.akk;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  console calcultor 
 */
public class CalculatorConsole {

    private final Calculator calcuator;
    private Double currentValue = null;
    private boolean newOperation = true;
    private Scanner scanner = new Scanner(System.in);

    public CalculatorConsole(Calculator calcuator) {
        this.calcuator = calcuator;
    }

    public void run() {

        boolean running = true;
        while (running) {
            try{
                if (newOperation && currentValue == null) {
                    System.out.println("Enter number:");
                    currentValue = scanner.nextDouble();
                    //System.out.println(currentValue); // display the entered number
                }
                
                System.out.println("Enter operation (+, -, *, /) or number:");
                String input = scanner.next();
                // handle quit
                if (input.equals("quit")) {
                    running = false;
                    continue;
                }

                if (input.matches("\\+|-|\\*|/")) {
                    handleOperation(input);     
                } else {
                    handleNumber(input);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or operation.");
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
            }
        }
    }


    private void handleOperation(String input){
        Operation operation = Operation.fromSymbol(input);
        System.out.println("Enter number:");
        double nextNum = scanner.nextDouble();
        currentValue = calcuator.calculate(operation, currentValue, nextNum);
        System.out.println(currentValue);
        if( currentValue.isNaN() || currentValue.isInfinite()){
            newOperation = true;
            currentValue = null;
        }
    }

    private void handleNumber(String input){
        currentValue = Double.parseDouble(input);
        newOperation = false;
    }

}
