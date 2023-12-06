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

    //Inizializza tutte le varibili necessarie sotto forma di chiave-valore (Variabile-ComplexNumbers)
    private void initializeVariables() {
        for(char var = 'A'; var <= 'Z'; var++){
            variables.put(var, new ComplexNumber(0,0));
        }
    }

    //prende la variabile dalla memoria
    public ComplexNumber getVariable(char variableName){
        return variables.get(variableName);
    }

    public void perform(String str, StackNumber stack) throws StackIsEmptyException, NoValueInVariableException {
        char firstChar = str.charAt(0);
        char secondChar = str.charAt(1);

        if(stack.isEmpty()){
            throw new StackIsEmptyException();

        }else if(firstChar == '<') {
                takeVariable(secondChar, stack); //stack is empty

        }else if(hasNoValue(secondChar)) {
            throw new NoValueInVariableException(secondChar);

        }else if(firstChar == '>') {
                saveVariable(secondChar, stack.peekNumber()); //no value
        }else if(firstChar == '+') {
                addValueToVariable(secondChar, stack.peekNumber()); //entrambe
        }else if(firstChar == '-') {
                subtractValueFromVariable(secondChar, stack.peekNumber()); //entrambe
        }
    }


    //salva il valore della variabile in Stack
    private void saveVariable(char varName, ComplexNumber number){
        variables.put(varName, number);
    }

    //take Value to stack and put into Variable
    private void takeVariable(char varName, StackNumber stack){
        stack.pushNumber(getVariable(varName));
    }
/*
    //Da cambiare le exeptiojn
 */
    private void addValueToVariable(char varName, ComplexNumber value){
            ComplexNumber currentNumber = getVariable(varName);
            variables.put(varName, currentNumber.add(value));
    }

    //sottrae un determinato valore ad uno contenuto in una variabile
    private void subtractValueFromVariable(char varName, ComplexNumber value){
            ComplexNumber currentNumber = getVariable(varName);
            variables.put(varName, currentNumber.subtract(value));
    }

    private boolean hasNoValue(char varName){
        return getVariable(varName).equals(new ComplexNumber(0,0));
    }

}
