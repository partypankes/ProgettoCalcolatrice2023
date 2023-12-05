package group21.calculator.exceptions;

public class InsufficientOperandsException extends Exception{
    public InsufficientOperandsException(){
        super("Errore: Operandi insufficienti nello stack per eseguire l'operazione.");
    }
}
