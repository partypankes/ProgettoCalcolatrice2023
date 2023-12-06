package group21.calculator.exceptions;

public class DivisionByZeroException extends RuntimeException{
    public DivisionByZeroException(){
        super("Math Error");
    }
}
