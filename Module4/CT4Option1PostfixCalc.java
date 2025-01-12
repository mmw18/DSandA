package Module4;
import java.io.*;
import java.util.*;

public class CT4Option1PostfixCalc {

    /*
     * This is the mmethod that is responsible for reading a single postfix expression 
     *  and giving the result. The parameter will be the expression being evaluated, 
     *  the return should be the final result (#), and I included a throw for incase 
     *  the expression is invalid.
     */
    public int evaluatePostfix(String postfixExpression) {
        // This is the stack that will hold the operands during evaluation
        Stack<Integer> operandStack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char currentChar = postfixExpression.charAt(i);

            // This is checking if the character is a digit
            if (Character.isDigit(currentChar)) {
                // If it is a digit, this will convert to an integer and push to the stack
                operandStack.push(Character.getNumericValue(currentChar));
            } else {
                // This is checking if there are at least 2 in the stack
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Sorry but this is an invalid postfix expression. Seems there are not enough operands.");
                }

                // This is popping two operands from the stack
                int secondOperand = operandStack.pop();
                int firstOperand = operandStack.pop();

                // This will perform the operation based on the operator used
                switch (currentChar) {
                    case '+':
                        operandStack.push(firstOperand + secondOperand);
                        break;
                    case '-':
                        operandStack.push(firstOperand - secondOperand);
                        break;
                    case '*':
                        operandStack.push(firstOperand * secondOperand);
                        break;
                    case '/':
                        if (secondOperand == 0) {
                            throw new ArithmeticException("Sorry but division by zero is not allowed.");
                        }
                        operandStack.push(firstOperand / secondOperand);
                        break;
                    case '%':
                        operandStack.push(firstOperand % secondOperand);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid: " + currentChar);
                }
            }
        }

        // When everything is all done, the stack should only have 1 thing which is the final result
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: too many operands.");
        }

        return operandStack.pop();
    }

    /*
     * This is the method that is reading all the expressions from the testing file and, 
     *  one by one, handing them to the above method to get the result of each. This method
     *  will take the any/all results and give them as a return in the console. 
     */
    public void evaluateExpressionsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String expressionLine;
            System.out.println("Postfix Calculator Results:");
            while ((expressionLine = reader.readLine()) != null) {
                try {
                    int result = evaluatePostfix(expressionLine);
                    System.out.println("Expression: " + expressionLine + " = " + result);
                } catch (Exception e) {
                    System.out.println("Expression: " + expressionLine + " Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the calculator
        CT4Option1PostfixCalc calculator = new CT4Option1PostfixCalc();

        // Sending the testing file to be evaluated
        String testFileName = "testingExpressions.java";
        calculator.evaluateExpressionsFromFile(testFileName);
    }
}
