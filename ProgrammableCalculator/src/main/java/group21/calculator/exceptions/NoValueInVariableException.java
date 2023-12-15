package group21.calculator.exceptions;

/**
 * This class represents a custom exception that is thrown when an attempt is made to access
 * a variable that does not have a value assigned to it. It extends RuntimeException, indicating
 * that it is an unchecked exception. This exception is used in scenarios where operations on
 * variables require that these variables have been previously assigned values, and such values
 * are not present.
 * The exception includes the name of the variable that triggered the exception, providing context
 * for the error.
 */
public class NoValueInVariableException extends RuntimeException{
    /**
     * Constructor for NoValueInVariableException.
     * Initializes a new instance of NoValueInVariableException with a custom error message
     * indicating the specific variable that lacks a value.
     *
     * @param var The character representing the variable that does not have a value.
     */
    public NoValueInVariableException(char var){
        super("Error: NoValue in " + var);
    }
}
