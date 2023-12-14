package group21.calculator.operation;

import group21.calculator.exceptions.InvalidExpressionException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;


public class Execute{

    private final StackNumber stack;
    private final Variables var;

    /**
     * Constructor to initialize the stack and variables.
     */
    public Execute() {
        this.stack = new StackNumber();
        this.var = new Variables();
    }

    /**
     * Retrieves the Variables instance.
     *
     * @return The current instance of Variables.
     */
    public Variables getVar() {
        return var;
    }

    /**
     * Retrieves the StackNumber instance.
     *
     * @return The current instance of StackNumber.
     */
    public StackNumber getStack() {
        return this.stack;
    }

    /**
     * Processes the given text expression.
     * The method handles square root operations, arithmetic operations, and complex numbers.
     * Throws InvalidExpressionException for invalid expressions.
     *
     * @param textArea The text expression to be processed.
     * @throws InvalidExpressionException If the expression is invalid.
     */
    public void elaborateTextArea(String textArea) throws InvalidExpressionException {
        if (textArea.contains ("sqrt")) {
            textArea = textArea.replace ("sqrt" , "√");
        }

        String regex = "[/±*\\-+√]+";
        if (isComplexNumber (textArea)) {
            this.stack.pushNumber (ComplexNumber.complexParse (textArea));

        }else if (textArea.matches ("^[/±*\\-+√><][A-Z]$")) {
            var.perform (textArea , this.stack);

        }else if (textArea.matches (regex)) {
            Operation.perform (textArea , this.stack);

        }else{
            throw new InvalidExpressionException ();
        }
    }

    /**
     * Checks if the given string represents a complex number.
     *
     * @param str The string to be checked.
     * @return True if the string is a complex number, otherwise false.
     */
    private boolean isComplexNumber(String str) {
        String reg = "([-+]?\\d*\\.?\\d+)([-+]\\d*\\.?\\d*j)?";
        return str.matches (reg) || str.matches ("[+-]?(\\d+)?j");
    }

}