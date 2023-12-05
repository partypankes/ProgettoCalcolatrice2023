package group21.calculator.operation;

import group21.calculator.exceptions.*;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

/* La classe Execute prende il valore String della Text-Area e lo elabora,
** determinando l'inserimento (numero, operazione,  */
public class Execute /* extends StackNumber */{

    private StackNumber stack;
    private Variables var;
    private final String regex = "[/±*\\-+√]+";


    public Execute(){
        this.stack = new StackNumber();
        this.var = new Variables();
    }

    public StackNumber getStack() {
        return this.stack;
    }

    public void elaboraTextArea(String textArea) throws InvalidExpressionException{
            if (textArea.contains("sqrt")) {
                textArea = textArea.replace("sqrt", "√");
            }
            //textArea.contains("j") || textArea.matches("\\d+") || textArea.matches("[-]\\d+")|| textArea.matches("\\d+[.].*") || textArea.matches("[-]\\d+[.].*")
            if (isComplexNumber(textArea)) {
                this.stack.pushNumber(ComplexNumber.complexParse(textArea));
                return;
            } else if (textArea.matches("^[+\\-><]{1}[A-Z]{1}")) {
                var.perform(textArea, this.stack);
                return;
            } else if (textArea.matches(regex) ) {
                //matches per operazioni: prende text area e la salva come inverso
                Operation.perform(textArea, this.stack);
                return;
            }else{
                throw new InvalidExpressionException(textArea);
            }
    }

    public boolean isComplexNumber(String str){
        String reg = "([-+]?\\d*\\.?\\d+)([-+]\\d*\\.?\\d*j)?";
        return str.matches(reg) || str.matches("[+-]?\\d+j");
    }

    public String print(){
        return stack.printStack();
    }
}