package group21.calculator.operation;

import group21.calculator.exceptions.InvalidExpressionException;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

/* La classe Execute prende il valore String della Text-Area e lo elabora,
 ** determinando l'inserimento (numero, operazione,  */
public class Execute /* extends StackNumber */ {

    private StackNumber stack;
    private Variables var;
    private final String regex = "[/±*\\-+√]+";


    public Execute () {
        this.stack = new StackNumber ();
        this.var = new Variables ();
    }

    public StackNumber getStack () {
        return this.stack;
    }

    public void elaboraTextArea (String textArea) throws InvalidExpressionException {
        if (textArea.contains ("sqrt")) {
            textArea = textArea.replace ("sqrt" , "√");
        }

        if (isComplexNumber (textArea)) {
            this.stack.pushNumber (ComplexNumber.complexParse (textArea));

        }else if (textArea.matches ("^[+\\-><]{1}[A-Z]{1}")) {
            var.perform (textArea , this.stack);

        }else if (textArea.matches (regex)) {
            Operation.perform (textArea , this.stack);

        }else{
            throw new InvalidExpressionException ();
        }
    }

    public boolean isComplexNumber (String str) {
        String reg = "([-+]?\\d*\\.?\\d+)([-+]\\d*\\.?\\d*j)?";
        return str.matches (reg) || str.matches ("[+-]?\\d+j");
    }

    public String print () {
        return stack.printStack ();
    }
}