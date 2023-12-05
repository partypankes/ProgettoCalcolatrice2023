package group21.calculator.operation;

import group21.calculator.exceptions.*;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

/* La classe Execute prende il valore String della Text-Area e lo elabora,
** determinando l'inserimento (numero, operazione,  */
public class Execute /* extends StackNumber */{

    private StackNumber stack;
    private Variables var;
    private final String regex = ".*[/±*\\-+√].*";


    public Execute(){
        this.stack = new StackNumber();
        this.var = new Variables();
    }



    public void elaboraTextArea(String textArea) {
            if (textArea.contains("sqrt")) {
                textArea = textArea.replace("sqrt", "√");
            }

    public StackNumber getStack() {
        return stack;
    }


            if (textArea.contains("j") || textArea.matches("\\d+")) {
                stack.pushNumber(ComplexNumber.complexParse(textArea));

            } else if (textArea.matches(".*[A-Z]1")) {
                var.perform(textArea, this.stack);

            } else if (textArea.matches(regex)) {
                //matches per operazioni: prende text area e la salva come inverso
                Operation.perform(textArea, this.stack);
            }
    }

    public String print(){
        return stack.printStack();
    }
}