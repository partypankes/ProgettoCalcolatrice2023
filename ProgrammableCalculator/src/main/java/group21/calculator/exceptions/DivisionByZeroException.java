package group21.calculator.exceptions;

public class DivisionByZeroException extends Exception{
    public DivisionByZeroException(){
        super("Errore: divisione per zero.");
    }
}
