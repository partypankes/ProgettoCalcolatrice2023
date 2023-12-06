package group21.calculator.exceptions;

public class InvalidExpressionException extends RuntimeException{
    public InvalidExpressionException(){
        super("Error: NoValid Expression");

    }
}
