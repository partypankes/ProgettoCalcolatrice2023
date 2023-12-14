package group21.calculator.operation;

import group21.calculator.exceptions.DivisionByZeroException;
import group21.calculator.exceptions.NoValueInVariableException;
import group21.calculator.exceptions.StackIsEmptyException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a container for variables used in calculations and operation with them.
 * It stores variables as key-value pairs, where the key is a character and the value is a ComplexNumber.
 * The class provides methods to manipulate these variables.
 */
public class Variables {

    private final Map<Character, ComplexNumber> variables;

    /**
     * Constructor for Variables.
     * Initializes a new HashMap to store the variables.
     */
    public Variables(){
        variables = new HashMap<>();
    }

    /**
     * Retrieves the map of variables.
     *
     * @return The map of variables with their associated ComplexNumber values.
     */
    public Map<Character, ComplexNumber> getVariables() {
        return variables;
    }

    /**
     * Searches for the variable in the map by its name.
     *
     * @param variableName The character name of the variable.
     * @return The ComplexNumber associated with the variable name, or null if not found.
     */
    public ComplexNumber searchVariable(char variableName){
        return variables.get(variableName);
    }

    /**
     * Performs operations on variables based on the specified string command.
     * Supports various operations such as assignment, addition, subtraction, multiplication,
     * division, square root, and sign inversion on variables using a stack for intermediate values.
     *
     * @param str The operation command string.
     * @param stack The stack used for holding intermediate values during computation.
     * @throws StackIsEmptyException If the stack is empty when an operation requires a value from it.
     * @throws NoValueInVariableException If a required variable has no assigned value.
     */
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

        }else if(firstChar == '*') {
            multiplyValueToValue(secondChar,stack.peekNumber(), stack.isEmpty());

        }else if(firstChar == '/') {
            divideValueFromValue(secondChar, stack.peekNumber(), stack.isEmpty ());

        }else if(firstChar == '√') {
            makeSqrtOfVariable(secondChar);

        }else if(firstChar == '±') {
            makeInvertSignOfVariable(secondChar);

        }

    }

    /**
     * Pushes a number into a variable. If the stack is empty, throws a StackIsEmptyException.
     *
     * @param varName The name of the variable.
     * @param number The complex number to be stored in the variable.
     * @param isStackEmpty Indicates whether the stack is empty.
     * @throws StackIsEmptyException If the stack is empty.
     */
    private void pushInVariable(char varName, ComplexNumber number, boolean isStackEmpty) throws StackIsEmptyException{
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else{
            variables.put(varName, number);
        }
    }

    /**
     * Takes a value from a variable and pushes it onto the stack.
     *
     * @param varName The name of the variable.
     * @param stack The stack where the number will be pushed.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void takeFromVariable(char varName, StackNumber stack) throws NoValueInVariableException{
        if(hasNoValue(varName)){
            throw new NoValueInVariableException(varName);
        }else{
            stack.pushNumber(searchVariable(varName));
        }
    }

    /**
     * Adds a value from the stack to the specified variable.
     *
     * @param varName The name of the variable.
     * @param value The complex number to be added to the variable's value.
     * @param isStackEmpty Indicates whether the stack is empty.
     * @throws StackIsEmptyException If the stack is empty.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void addValueToVariable(char varName, ComplexNumber value, boolean isStackEmpty) {
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = searchVariable(varName);
            variables.put(varName, currentNumber.add(value));
        }
    }

    /**
     * Subtracts a value from the stack from the specified variable.
     *
     * @param varName The name of the variable.
     * @param value The complex number to be subtracted from the variable's value.
     * @param isStackEmpty Indicates whether the stack is empty.
     * @throws StackIsEmptyException If the stack is empty.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void subtractValueFromVariable(char varName, ComplexNumber value, boolean isStackEmpty){
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = searchVariable(varName);
            variables.put (varName , currentNumber.subtract(value));
        }
    }

    /**
     * Multiplies a value from the stack with the specified variable's value.
     *
     * @param varName The name of the variable.
     * @param value The complex number to multiply with the variable's value.
     * @param isStackEmpty Indicates whether the stack is empty.
     * @throws StackIsEmptyException If the stack is empty.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void multiplyValueToValue(char varName, ComplexNumber value, boolean isStackEmpty){
        if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = searchVariable(varName);
            variables.put (varName , currentNumber.multiply(value));
        }
    }

    /**
     * Divides a variable's value by a value from the stack.
     *
     * @param varName The name of the variable.
     * @param value The complex number to divide the variable's value by.
     * @param isStackEmpty Indicates whether the stack is empty.
     * @throws DivisionByZeroException If attempting to divide by zero.
     * @throws StackIsEmptyException If the stack is empty.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void divideValueFromValue(char varName, ComplexNumber value, boolean isStackEmpty){

        double sum = (value.getReal() * value.getReal()) + (value.getImaginary() * value.getImaginary());

        if(sum == 0) {
            throw new DivisionByZeroException();
        }else if(isStackEmpty){
            throw new StackIsEmptyException ();
        }else if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = searchVariable(varName);
            variables.put (varName , currentNumber.divide(value));
        }

    }

    /**
     * Calculates the square root of the specified variable's value.
     *
     * @param varName The name of the variable.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void makeSqrtOfVariable(char varName){
        if(hasNoValue(varName)){
                throw new NoValueInVariableException (varName);
        }else{
                ComplexNumber currentNumber = searchVariable(varName);
                variables.put (varName , currentNumber.squareRoot());
        }
    }

    /**
     * Inverts the sign of the specified variable's value.
     *
     * @param varName The name of the variable.
     * @throws NoValueInVariableException If the variable does not have a value.
     */
    private void makeInvertSignOfVariable(char varName){
        if(hasNoValue(varName)){
            throw new NoValueInVariableException (varName);
        }else{
            ComplexNumber currentNumber = searchVariable(varName);
            variables.put (varName , currentNumber.invertSign());
        }
    }

    /**
     * Checks if a variable has no value.
     *
     * @param varName The name of the variable.
     * @return True if the variable has no value, false otherwise.
     */
    private boolean hasNoValue(char varName){
        return searchVariable(varName) == (null);
    }

}
