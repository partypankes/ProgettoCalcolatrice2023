package group21.calculator.type;
import group21.calculator.exceptions.InsufficientOperandsException;
import group21.calculator.exceptions.StackIsEmptyException;
import group21.calculator.type.ComplexNumber;

import java.util.Stack;


/*Classe dello stack, contenete tutti i metodi dello stack di inserimento e rimozione.
* Implementa anche tutti i metodi richiesti dallo StackManipulation:
* clear, -> rimuove tutti gli elementi dallo stack
* drop, -> elimina il top elemento
* dup, -> pusha una copia dell'ultimo elemento
* over, -> pusha una copia del penultimo valore (before top)
* swap -> cambia la posizione degli ultimi due valori*/
public class StackNumber {

    private Stack<ComplexNumber> stack;

    //costruttore dello stack
    public StackNumber() {
        stack = new Stack<>();
    }

    //getter StackNumber
    public int getStackSize() {
        return stack.size();
    }

    //Pusha il numero nello StackNumber
    public void pushNumber(ComplexNumber number){
        stack.push(number);
    }

    //legge il valore nella top dello stack
    public ComplexNumber peekNumber(){
        if (isEmpty()){
            throw new StackIsEmptyException();
        }
        return stack.peek();
    }

    //DROP: rimuove e ritorna l'elemento top dello stack
    public ComplexNumber dropNumber(){
        if (isEmpty()){
            throw new StackIsEmptyException();
        }
       return stack.pop();
    }

    //CLEAR: cancella il contenuto dello stack
    public void clearNumber(){
        stack.clear();
    }

    //DUP: legge l'elemento nella top dello stack e pusha una sua copia nello stack
    public void dupNumber(){
        if (isEmpty()){
            throw new StackIsEmptyException();
        }
            pushNumber(peekNumber());
    }

    //metodo isEmpty dello stack
    public boolean isEmpty() { return stack.isEmpty();}

    //SWAP: scambia l'elemento nella top dello stack con il penultimo - [l'operazione puo essere svolta solo se ci sono almeno due lementi nello stack] le eccezioni sono inclue in drop e peek
    public void swapNumber() {
        if (getStackSize() < 2) {
            throw new InsufficientOperandsException();
        }

        ComplexNumber topNumber = dropNumber();
        ComplexNumber secondNumber = dropNumber();

        pushNumber(topNumber);
        pushNumber(secondNumber);

    }

    //OVER: pusha una copia del penultimo elemento - [l'operazione puo essere svolta solo se ci sono almeno due lementi nello stack] le eccezioni sono inclue in drop e peek
    public void overNumber() {
        if (getStackSize() < 2) {
            throw new InsufficientOperandsException();
        }
        ComplexNumber topNumber = dropNumber();
        ComplexNumber secondNumber = peekNumber();

        pushNumber(topNumber);
        pushNumber(secondNumber);

    }

    public String printStack(){
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < this.stack.size(); i++){
            str.append(stack.get(i).toString());
            str.append("\n");
        }
        return str.toString();
    }

}
