package group21.calculator.operation;

import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

import java.util.HashMap;
import java.util.Map;

public class Variables implements PerformOperation {
    private final StackNumber stack;
    private Map<Character, ComplexNumber> variables;
    public Variables(StackNumber stack){
         this.stack = stack;
        variables=new HashMap<>();
    }


    /*//Inizializza tutte le varibili necessarie sotto forma di chiave-valore (Variabile-ComplexNumbers)
    private void initializeVariables() {
        for(char variable= 'A'; variable<='Z'; variable++){
            variables.put(variable, new ComplexNumber(0,0));
        }
    }

    //Salva il valore dal top dello stack nella variabile specificata
    public void saveVariable(char variableName, Stack<ComplexNumber> stack){
        variables.put(variableName, stack.pop());
    }

    //prende la variabile dalla memoria
    public ComplexNumber getVariable(char variableName){
           return variables.get(variableName);
    }

    //Prende il valore dal top dello stack e lo aggiunge al valore corrente della variabile specificata
    public void addValueToVariable(char variableName, Stack<ComplexNumber> stack){
         ComplexNumber adder = stack.pop();
        ComplexNumber currentNumber = getVariable(variableName);
        variables.put(variableName, currentNumber.add(adder));
    }

    public void subtractValueFromVariable(char variableName, Stack<ComplexNumber> stack){
        ComplexNumber subtracter=stack.pop();
        ComplexNumber currentNumber=getVariable(variableName);
        variables.put(variableName, currentNumber.subtract(subtracter));
    }

    // Prende il valore dalla variabile specificata e lo inserisce nello stack
    public void pushVariable(char variableName, Stack<ComplexNumber> stack){
        stack.push(variables.get(variableName));
    }
*/
    @Override
    public void perform(String str) {
       /* switch (str.charAt(0)) {
            case '>':
                saveVariable(str.charAt(1), stack);
                break;
            case '<':
                pushVariable(str.charAt(1), stack);
                break;
            case '+':
                addValueToVariable(str.charAt(1), stack);
                break;
            case '-':
                subtractValueFromVariable(str.charAt(1), stack);
                break;
        }*/
    }
/*
    //Inizializza tutte le varibili necessarie sotto forma di chiave-valore (Variabile-ComplexNumbers)
    private void initializeVariables() {
        for(char variable= 'A'; variable<='Z'; variable++){
            variables.put(variable, new ComplexNumber(0,0));
        }
    }

    //salva il valore della variabile in memoria
    public void saveVariable(char variableName, ComplexNumber value){
        variables.put(variableName, value);
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

    public void substractValueFromVariable(char variableName, ComplexNumber value){
        ComplexNumber currentNumber= getVariable(variableName);
        variables.put(variableName, currentNumber.subtract(value));
    }
*/





}
