package group21.calculator.operation;

import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

/* La classe Execute prende il valore String della Text-Area e lo elabora,
** determinando l'inserimento (numero, operazione,  */
public class Execute /* extends StackNumber */{
    private String textArea;
    private StackNumber stack;
    private Operation op;
    private Variables var;


    public Execute(String textArea){
        this.stack = new StackNumber();
        this.textArea = textArea;
        this.op = new Operation(stack);
        this.var = new Variables(stack);
    }


    public void elaboraTextArea() throws Exception{
        if(textArea.contains("sqrt"))
        {
            textArea = textArea.replace("sqrt","√");
        }

        if(textArea.contains("j") || textArea.matches("\\d+")) {
            stack.pushNumber(ComplexNumber.complexParse(textArea));

        } else if(textArea.matches(".*[A-Z]1")){
            var.perform(textArea);

        } else if(textArea.matches(".*[/±*\\-+√].*") ){
            //matches per operazioni: prende text area e la salva come inverso
            op.perform(new StringBuilder(textArea).reverse().toString());
        } else {
            throw new Exception("Invalid Input");
        }
    }
}
