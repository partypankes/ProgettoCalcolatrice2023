package group21.calculator.exceptions;

/**
 * This class represents a custom exception that is thrown when an invalid expression is encountered
 * during the processing of calculations. It extends RuntimeException, indicating that it is an unchecked
 * exception. This exception typically arises in scenarios where the provided expression cannot be parsed
 * or does not conform to the expected format or syntax for mathematical expressions.
 * The exception is initialized with a default error message "Error: NoValid Expression".
 */
public class InvalidExpressionException extends RuntimeException{
    /**
     * Constructor for InvalidExpressionException.
     * Initializes a new instance of InvalidExpressionException with the default error message
     * "Error: NoValid Expression".
     */
    public InvalidExpressionException(){
        super("Error: NoValid Expression");

    }
}
