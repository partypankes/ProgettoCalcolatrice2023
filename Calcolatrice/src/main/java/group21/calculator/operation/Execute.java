package group21.calculator.operation;

import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;

/* La classe Execute prende il valore String della Text-Area e lo elabora,
** determinando l'inserimento (numero, operazione,  */
public class Execute /* extends StackNumber */{
    private String textArea;
    private StackNumber stack;
    private Variables var;

    private final String regex = ".*[/±*\\-+√].*";


    public Execute(String textArea){
        this.stack = new StackNumber();
        this.textArea = textArea;
        this.var = new Variables();
    }

    public void setTextArea(String a) {
        this.textArea = a;
    }

    public void elaboraTextArea() throws Exception{
        if(this.textArea.contains("sqrt")){
            this.textArea = textArea.replace("sqrt","√");}

        if(textArea.contains("j") || textArea.matches("\\d+")){
            stack.pushNumber(ComplexNumber.complexParse(textArea));

        }  else if(textArea.matches(".*[A-Z]1")){
            var.perform(this.textArea, this.stack);

        }  else if(textArea.matches(regex)){
            //matches per operazioni: prende text area e la salva come inverso
            Operation.perform(this.textArea,this.stack);
        }
    }

    public String print(){
        return stack.printStack();
    }
}