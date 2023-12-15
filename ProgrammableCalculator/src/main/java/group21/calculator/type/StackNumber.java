package group21.calculator.type;

import group21.calculator.exceptions.InsufficientOperandsException;
import group21.calculator.exceptions.StackIsEmptyException;

import java.util.Stack;

/**
 * This class represents a stack specifically designed for holding ComplexNumber objects.
 * It provides various stack operations such as push, pop, peek, and additional operations
 * like duplicate, swap, and over, tailored for use in a calculator context. This stack acts
 * as the memory of the calculator, storing the numbers upon which operations are performed.
 */
public class StackNumber {

    private final Stack<ComplexNumber> stack;

    /**
     * Constructor for the StackNumber class. Initializes a new Stack object to hold ComplexNumber instances.
     */
    public StackNumber() {
        stack = new Stack<>();
    }

    /**
     * Gets the current size of the stack.
     *
     * @return The size of the stack.
     */
    public int getStackSize() {
        return stack.size();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes a ComplexNumber onto the stack.
     *
     * @param number The ComplexNumber to be added to the stack.
     */
    public void pushNumber(ComplexNumber number){
        stack.push(number);
    }

    /**
     * Peeks at the top element of the stack without removing it.
     *
     * @return The ComplexNumber at the top of the stack.
     * @throws StackIsEmptyException If the stack is empty.
     */
    public ComplexNumber peekNumber() throws StackIsEmptyException{
        if (isEmpty()){
            throw new StackIsEmptyException();
        }else{
            return stack.peek ();
        }
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return The ComplexNumber removed from the top of the stack.
     * @throws StackIsEmptyException If the stack is empty.
     */
    public ComplexNumber dropNumber() throws StackIsEmptyException{
        if(isEmpty()){
            throw new StackIsEmptyException();
        }else{
            return stack.pop();
        }
    }

    /**
     * Clears the stack of all elements.
     */
    public void clearNumber(){
        stack.clear();
    }

    /**
     * Duplicates the top element of the stack.
     *
     * @throws StackIsEmptyException If the stack is empty.
     */
    public void dupNumber() throws StackIsEmptyException{
        if (isEmpty()){
            throw new StackIsEmptyException();
        }else{
            pushNumber(peekNumber());
        }
    }

    /**
     * Swaps the top two elements of the stack.
     *
     * @throws StackIsEmptyException If the stack is empty.
     * @throws InsufficientOperandsException If there are less than two elements in the stack.
     */
    public void swapNumber() throws StackIsEmptyException, InsufficientOperandsException{
        if(stack.isEmpty()){
            throw new StackIsEmptyException ();
        }else if (getStackSize() < 2) {
            throw new InsufficientOperandsException();
        } else {
            ComplexNumber topNumber = dropNumber();
            ComplexNumber secondNumber = dropNumber();

            pushNumber(topNumber);
            pushNumber(secondNumber);
        }
    }

    /**
     * Pushes a copy of the second-to-top element of the stack onto the top.
     *
     * @throws StackIsEmptyException If the stack is empty.
     * @throws InsufficientOperandsException If there are less than two elements in the stack.
     */
    public void overNumber() throws StackIsEmptyException, InsufficientOperandsException{
        if (stack.isEmpty()){
            throw new StackIsEmptyException ();
        }else if (getStackSize() < 2) {
            throw new InsufficientOperandsException();
        }else {
            ComplexNumber topNumber = dropNumber();
            ComplexNumber secondNumber = peekNumber();

            pushNumber(topNumber);
            pushNumber(secondNumber);
        }
    }

    /**
     * Retrieves the string representation of the number at the specified index in the stack.
     *
     * @param i The index of the number in the stack.
     * @return The string representation of the ComplexNumber at the specified index.
     */
    public String getNumber(int i) {
        return stack.get(i).toString();
    }


}
