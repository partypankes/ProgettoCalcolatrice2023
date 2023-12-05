package group21.calculator.exceptions;

public class NoValueVariable extends RuntimeException{
    public NoValueVariable(char variable){
        super("Errore: nessun valore da attribuire alla variabile ' " + variable +" '");
    }
}
