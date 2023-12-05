package group21.calculator.exceptions;

public class InvalidComplexNumberFormatExpression extends RuntimeException{
    public InvalidComplexNumberFormatExpression(String expression){
        super("Errore: Formato del numero complesso non valido - " + expression);

    }
}
