package group21.calculator.operation;

import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

import java.util.HashMap;
import java.util.Map;

public class peròVariables {

    private final Map<Character, ComplexNumber> variables;
    public Variables(){
        variables = new HashMap<>();
    }



    public void perform(String str,StackNumber stack) {
       switch (str.charAt(0)) {
            case '>':
                saveVariable(str.charAt(1),stack.peekNumber());
                break;
            case '<':
                stack.pushNumber(getVariable(str.charAt(1)));
                break;
            case '+':
                addValueToVariable(str.charAt(1),stack.peekNumber());
                break;
            case '-':
                subtractValueFromVariable(str.charAt(1),stack.peekNumber());
                break;
        }
    }

    //Inizializza tutte le varibili necessarie sotto forma di chiave-valore (Variabile-ComplexNumbers)
    private void initializeVariables() {
        for(char variable= 'A'; variable<='Z'; variable++){
            variables.put(variable, new ComplexNumber(0,0));
        }
    }

    //salva il valore della variabile in memoria
    public void saveVariable(char variableName, ComplexNumber number){
        variables.put(variableName, number);
    }

    //prende la variabile dalla memoria
    public ComplexNumber getVariable(char variableName){
           return variables.get(variableName);
    }

    //assegna un valore alla variabile
    public void addValueToVariable(char variableName, ComplexNumber value){
        ComplexNumber currentNumber= getVariable(variableName);
        variables.put(variableName, currentNumber.add(value));
    }

    public void subtractValueFromVariable(char variableName, ComplexNumber value){
        ComplexNumber currentNumber = getVariable(variableName);
        variables.put(variableName, currentNumber.subtract(value));
    }


}
