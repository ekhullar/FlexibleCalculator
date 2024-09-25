Flexible Calculator
A simple calculator console application that takes in mathematical expressions and evaluates them.

Features:
    Supports basic arithmetic operations: addition, subtraction, multiplication, and division
    Allows user to quit by typing "quit"

Requirements:
    Java 21 or later
    Gradle for building and dependencies management

Usage:
    Build the project using gradle build
    Run the project using  gradle -q --console plain run
    Enter mathematical expressions to evaluate, or type "quit" to exit

Design:
    Modular Architecture: The application is divided into separate modules for input handling and  calculation
        DefaultCalculator implements Calculator interface for calculation logic
        CalculatorConsole handles input and output for the console application
    Enum Operation: 
        Defines supported operations (addition, subtraction, multiplication, division) and makes it easy to add new operations.
    Open-Closed Principle (OCP):
        Add a new value to the Enum Operation
        The existing code is not modified when new operations are added. 
        The CalculatorConsole class remain unchanged, ensuring that the existing functionality is not affected.
    Maintainability
        Single responsibility principle: Each class has a single responsibility, making it easier to understand, modify, and replace individual components.



Note:
    Currently, only a single operation can be performed per expression. 

Testing
    Run tests using gradle test    




