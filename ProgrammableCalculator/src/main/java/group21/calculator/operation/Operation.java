package group21.calculator.operation;

import group21.calculator.exceptions.DivisionByZeroException;
import group21.calculator.exceptions.InsufficientOperandsException;
import group21.calculator.exceptions.StackIsEmptyException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

public class Operation {

    public Operation(){}

    /*perform() all operations by a String of Operators*/
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

    /*
     * Methods for dividing operations
     */
    private static boolean isUnaryOperator(char operator){
        return operator == '√' || operator == '±';
    }

    private static boolean isBinaryOperator(char operator){
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    /*
    * Perform Operation Methods
    */
    private static void performUnaryOperation(char operator, StackNumber stack){
        if(operator == '√'){
            stack.pushNumber(stack.dropNumber().squareRoot());
        } else if(operator == '±'){
            stack.pushNumber(stack.dropNumber().invertSign());
        }
    }

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
