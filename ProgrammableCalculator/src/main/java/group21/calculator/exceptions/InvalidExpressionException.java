package group21.calculator.exceptions;

public class InvalidExpressionException extends Exception{
    public InvalidExpressionException(String expression){
        super("Errore: espressione non valida - " + expression);

    }
}
