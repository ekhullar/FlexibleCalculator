package com.akk;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * console calcultor
 */
public class CalculatorConsole {

    private final Calculator calcuator;
    private Scanner scanner = new Scanner(System.in);

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public CalculatorConsole(Calculator calcuator) {
        this.calcuator = calcuator;
    }

    public void run() {

        Double currentValue = null;
        boolean running = true;
        help();
        while (running) {
            try {
                
                String input = scanner.next();
                // handle quit
                if (input.equals("quit")) {
                    running = false;
                    continue;
                }
                if (input.equals("help")) {
                    help();
                    continue;
                }

                if (is_valid_expression(input)) {
                    Double result = handleExpression(input);
                    currentValue = result;
                    System.out.println(ANSI_GREEN_BACKGROUND + currentValue + ANSI_RESET);
                } else if (input.matches("\\+|-|\\*|/")) {
                    Double result = handleOperation(input, currentValue);
                    if (result.isNaN() || result.isInfinite()) {
                        currentValue = null;
                    }
                    currentValue = result;
                    System.out.println(ANSI_GREEN_BACKGROUND + currentValue + ANSI_RESET);
                } else {
                    Double result = handleNumber(input);
                    currentValue = result;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or operation.");
                currentValue =  null;
                scanner.next();
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                currentValue =  null;
                scanner.next();
            }
        }
    }

    private void help() {
        System.out.println("Thanks for Using Flex Calculator ");
        System.out.println("Start with a number and operation in a new line (e.g., \"2 + 3\")\n" + //
                        "Or, enter a mathematical expression (e.g., \"2 + 3 * 4\")");
        System.out.println("help");
        System.out.println("quit - Exit the calculator");
    }

    private boolean is_valid_expression(String expression) {
        String pattern = "^[0-9]+([+%-*/][0-9]+)*$";
        return  expression.matches(pattern);
    }

    public double handleExpression(String expression) {
        List<String> tokens = getToken(expression);
        double result = Double.parseDouble(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String operator = tokens.get(i);
            double operand = Double.parseDouble(tokens.get(i + 1));
           //System.out.println(result + ":" + operator + ":" + operand);
            result = calcuator.calculate(Operation.fromSymbol(operator), result, operand);
        }
        return result;
    }

    private double handleOperation(String input, double currentValue) {
        Operation operation = Operation.fromSymbol(input);
        //System.out.println("Enter number:");
        double nextNum = scanner.nextDouble();
        Double result = calcuator.calculate(operation, currentValue, nextNum);
        return result;
    }

    private double handleNumber(String input) {
        return Double.parseDouble(input);
    }

    private List<String> getToken(String expression) {
        List<String> tokens = new ArrayList<>();
        String currentToken = "";
        for (char c : expression.toCharArray()) {
            if( Character.isWhitespace(c) ){
                continue;
            }
            if (Character.isDigit(c)) {
                currentToken += c;
            } else {
                tokens.add(currentToken);
                tokens.add(String.valueOf(c));
                currentToken = "";
            }
        }
        if (!currentToken.isEmpty()) {
            tokens.add(currentToken);
        }
        return tokens;
    }

}
