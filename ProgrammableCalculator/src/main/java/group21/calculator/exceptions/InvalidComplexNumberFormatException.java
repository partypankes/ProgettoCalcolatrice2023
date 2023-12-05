package group21.calculator.exceptions;

public class InvalidComplexNumberFormatException extends RuntimeException{
    public InvalidComplexNumberFormatException(String expression){
        super("Errore: Formato del numero complesso non valido - " + expression);

    }
}
