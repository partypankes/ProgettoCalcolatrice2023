package group21.calculator.exceptions;

/**
 * This class represents a custom exception that is thrown when an operation is attempted on an empty stack.
 * It extends RuntimeException, indicating that it is an unchecked exception. This exception is typically
 * used in scenarios where an operation requires elements from the stack, but the stack is found to be empty,
 * indicating an error in either the sequence of operations or the input provided to the calculator.
 * The exception is initialized with a default error message "Error: EmptyStack".
 */
public class StackIsEmptyException extends RuntimeException{
    /**
     * Constructor for StackIsEmptyException.
     * Initializes a new instance of StackIsEmptyException with the default error message
     * "Error: EmptyStack".
     */
    public StackIsEmptyException(){
        super("Error: EmptyStack");
    }
}
