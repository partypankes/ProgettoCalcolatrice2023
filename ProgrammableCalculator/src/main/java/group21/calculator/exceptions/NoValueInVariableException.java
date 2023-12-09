package group21.calculator.exceptions;

public class NoValueInVariableException extends RuntimeException{
    public NoValueInVariableException(char var){
        super("Error: NoValue in " + var);
    }
}
