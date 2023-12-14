package group21.calculator.exceptions;

/**
 * This class represents a custom exception that is thrown when there are insufficient operands
 * for an operation in a calculation. It extends RuntimeException, indicating that it is an unchecked
 * exception that can occur during the operation of the calculator, specifically in scenarios where
 * an operation requires more operands than are available on the stack or in the current context.
 * The exception is initialized with a default error message "Error: InsufficientOperands".
 */
public class InsufficientOperandsException extends RuntimeException{
    /**
     * Constructor for InsufficientOperandsException.
     * Initializes a new instance of InsufficientOperandsException with the default error message
     * "Error: InsufficientOperands".
     */
    public InsufficientOperandsException(){
        super("Error:InsufficientOperands");
    }
}
