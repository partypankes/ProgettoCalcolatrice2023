package group21.calculator.operation;


import group21.calculator.exceptions.NoValueInVariableException;
import group21.calculator.exceptions.StackIsEmptyException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

import java.util.HashMap;
import java.util.Map;

public class Variables {

    private final Map<Character, ComplexNumber> variables;

    public Variables(){

        variables = new HashMap<>();

    }

    public Map<Character, ComplexNumber> getVariables() {
        return variables;
    }

    /*//Inizializza tutte le varibili necessarie sotto forma di chiave-valore (Variabile-ComplexNumbers)
    private void initializeVariables() {
        for(char var = 'A'; var <= 'Z'; var++){
            variables.put(var, null);
        }
    }*/

    //prende la variabile dalla memoria
    public ComplexNumber getVariable(char variableName){
        return variables.get(variableName);
    }

    public void perform(String str, StackNumber stack) throws StackIsEmptyException, NoValueInVariableException {
        char firstChar = str.charAt(0);
        char secondChar = str.charAt(1);

        if(firstChar == '<') {
            takeFromVariable (secondChar , stack);

        }else if(firstChar == '>') {
            pushInVariable(secondChar, stack.peekNumber(), stack.isEmpty());

        }else if(firstChar == '+') {
            addValueToVariable(secondChar, stack.peekNumber(), stack.isEmpty ());

        }else if(firstChar == '-') {
            subtractValueFromVariable(secondChar, stack.peekNumber(), stack.isEmpty ());
        }
    }


    //mette il valore della variabile in Stack
    private void pushInVariable(char varName, ComplexNumber number, boolean isStackEmpty) throws StackIsEmptyException{
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else{
            variables.put(varName, number);
        }
    }

    //take Value to stack and put into Variable
    private void takeFromVariable(char varName, StackNumber stack) throws NoValueInVariableException{
        if(hasNoValue(varName)){
            throw new NoValueInVariableException(varName);
        }else{
            stack.pushNumber(getVariable(varName));
        }
    }
/*
    //Da cambiare le exeptiojn
 */
    private void addValueToVariable(char varName, ComplexNumber value, boolean isStackEmpty) throws StackIsEmptyException, NoValueInVariableException{
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = getVariable(varName);
            variables.put(varName, currentNumber.add(value));
        }
    }

    //sottrae un determinato valore ad uno contenuto in una variabile
    private void subtractValueFromVariable(char varName, ComplexNumber value, boolean isStackEmpty){
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = getVariable (varName);
            variables.put (varName , currentNumber.subtract (value));
        }
    }

    private boolean hasNoValue(char varName){
        return getVariable(varName) == (null);
    }

}
