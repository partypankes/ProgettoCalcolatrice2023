package com.example.calcolatrice;
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

    //Pusha il numero nello StackNumber
    public void pushNumber(ComplexNumber number){
        stack.push(number);
    }

    //legge il valore nella top dello stack
    public ComplexNumber peekNumber(){
        return stack.peek();
    }

    //rimuove e ritorna l'elemento top dello stack
    public ComplexNumber dropNumber(){
       return stack.pop();
    }

    // cancella il contenuto dello stack
    public void clearNumber(){
        stack.clear();
    }

    //legge l'elemento nella top dello stack e pusha una sua copia nello stack
    public void dupNumber(){
            pushNumber(peekNumber());
    }





}
