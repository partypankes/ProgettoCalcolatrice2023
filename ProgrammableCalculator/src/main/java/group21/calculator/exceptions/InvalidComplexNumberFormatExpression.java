package group21.calculator.exceptions;

public class InvalidComplexNumberFormatExpression extends Exception{
    public InvalidComplexNumberFormatExpression(String expression){
        super("Errore: Formato del numero complesso non valido - " + expression);

    }
}
