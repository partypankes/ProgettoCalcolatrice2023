package group21.calculator.exceptions;

public class StackIsEmptyException extends RuntimeException{
    public StackIsEmptyException(){
        super("Error: EmptyStack");
    }
}
