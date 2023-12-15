package group21.calculator.operation;

import group21.calculator.exceptions.DivisionByZeroException;
import group21.calculator.exceptions.InsufficientOperandsException;
import group21.calculator.exceptions.StackIsEmptyException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

/**
 * This class provides methods to perform arithmetic operations on numbers stored in a StackNumber.
 * It supports both unary and binary operations, including basic arithmetic and complex number operations.
 */
public class Operation {

    public Operation(){}

    /**
     * Performs operations on numbers in the stack based on a string of operators.
     * It processes each character in the string as an operator and applies it to the numbers in the stack.
     *
     * @param operators A string containing the operators to be applied.
     * @param numbers The stack of numbers on which operations are to be performed.
     * @throws StackIsEmptyException If the stack is empty when an operation requires a number from it.
     * @throws InsufficientOperandsException If there are not enough operands in the stack for a binary operation.
     */
    public static void perform(String operators, StackNumber numbers) throws StackIsEmptyException, InsufficientOperandsException{
        for (int i = 0; i < operators.length(); i++) {
            char operator = operators.charAt(i);
            if (isUnaryOperator(operator)) {
                if (numbers.isEmpty()) {
                    throw new StackIsEmptyException();
                }else{
                    performUnaryOperation(operator, numbers);
                }
            } else if (isBinaryOperator(operator)) {
                if (numbers.isEmpty()) {
                    throw new StackIsEmptyException();
                }else if (numbers.getStackSize() == 1) {
                    throw new InsufficientOperandsException();
                }else{
                    performBinaryOperation(operator, numbers);
                }
            }
        }
    }

    /**
     * Checks if the given character is a unary operator.
     *
     * @param operator The character to be checked.
     * @return True if the operator is unary (e.g., square root, sign inversion), otherwise false.
     */
    private static boolean isUnaryOperator(char operator){
        return operator == '√' || operator == '±';
    }

    /**
     * Checks if the given character is a binary operator.
     *
     * @param operator The character to be checked.
     * @return True if the operator is binary (e.g., addition, subtraction, multiplication, division), otherwise false.
     */
    private static boolean isBinaryOperator(char operator){
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    /**
     * Performs a unary operation (e.g., square root, sign inversion) on the top number of the stack.
     *
     * @param operator The unary operator to apply.
     * @param stack The stack of numbers.
     */
    private static void performUnaryOperation(char operator, StackNumber stack){
        if(operator == '√'){
            stack.pushNumber(stack.dropNumber().squareRoot());
        } else if(operator == '±'){
            stack.pushNumber(stack.dropNumber().invertSign());
        }
    }

    /**
     * Performs a binary operation (e.g., addition, subtraction, multiplication, division) on the top two numbers of the stack.
     *
     * @param operator The binary operator to apply.
     * @param stack The stack of numbers.
     * @throws DivisionByZeroException If attempting to divide by zero.
     */
    private static void performBinaryOperation(char operator, StackNumber stack) throws DivisionByZeroException{
        if(operator == '+'){
            stack.pushNumber(stack.dropNumber().add(stack.dropNumber()));
        } else if(operator == '-'){
            stack.swapNumber();
            stack.pushNumber(stack.dropNumber().subtract(stack.dropNumber()));
        } else if(operator == '*'){
            stack.pushNumber(stack.dropNumber().multiply(stack.dropNumber()));
        } else if(operator == '/'){
            ComplexNumber denominator = stack.peekNumber();
            stack.swapNumber();

            double sum = (denominator.getReal() * denominator.getReal()) + (denominator.getImaginary() * denominator.getImaginary());
            if(sum == 0){
                stack.swapNumber();
                throw new DivisionByZeroException();
            }else{
                stack.pushNumber(stack.dropNumber().divide(stack.dropNumber()));
            }
        }
    }


}
