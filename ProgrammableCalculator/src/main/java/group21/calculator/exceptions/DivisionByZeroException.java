package group21.calculator.exceptions;

/**
 * This class represents an exception that is thrown when a division by zero occurs in a calculation.
 * It extends RuntimeException, indicating that it is an unchecked exception that might occur during the
 * operation of the calculator, when a division operation attempts to divide a number by zero.
 * The exception is initialized with a default error message "Math Error".
 */
public class DivisionByZeroException extends RuntimeException {

    /**
     * Constructor for DivisionByZeroException.
     * Initializes a new instance of DivisionByZeroException with the default error message "Math Error".
     */
    public DivisionByZeroException() {
        super("Math Error");
    }
}
