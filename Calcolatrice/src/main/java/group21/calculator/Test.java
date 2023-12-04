package group21.calculator;

import group21.calculator.operation.Execute;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//POSSIBILE IDEA -> stack su GUI non visibile fino alla fine della stringa delle operazioni
// array di operazioni da swappare prima di eseguirle
public class Test  {



    public static void main(String[] args) throws Exception  {

        // (3 + 6 / 2) -> 3 6 2 + /
        //             -> 3 3 2 * + -> swap -> 3 2 3 * +  ->  3 3 +  ->  6

        //

        //In TextArea viene inserito un valore da GUI:
        String textArea = "30+5j";
        Execute execute = new Execute("sqrt");
        //stack.pushNumber(ComplexNumber.complexParse("6+5j"));
        //stack.pushNumber(ComplexNumber.complexParse("2+5j"));
        execute.elaboraTextArea();






    }
}
