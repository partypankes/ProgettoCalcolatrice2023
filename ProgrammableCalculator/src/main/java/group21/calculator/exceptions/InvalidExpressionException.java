package group21.calculator.exceptions;

public class InvalidExpressionException extends RuntimeException{
    public InvalidExpressionException(String expression){
        super("Errore: espressione non valida - " + expression);

    }
}
