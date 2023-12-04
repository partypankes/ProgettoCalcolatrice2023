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


        //In TextArea viene inserito un valore da GUI:
//<<<<<<< Updated upstream
        String textArea = "30+5j";
        Execute execute = new Execute("sqrt");
        //stack.pushNumber(ComplexNumber.complexParse("6+5j"));
        //stack.pushNumber(ComplexNumber.complexParse("2+5j"));
        execute.elaboraTextArea();
//=======
            /*
        String [] textArea = new String[5];
        textArea[0] = "3+2j";
        textArea[1] = "5";
        textArea[2] = "4";
        textArea[3] = "12";
        textArea[4] = "+";
        Execute exe = new Execute(textArea[0]);
        exe.elaboraTextArea();
        /*
        for (String s : textArea) {
            Execute execute = new Execute(s);
            execute.elaboraTextArea();
        }

        exe.print();
                */

//>>>>>>> Stashed changes






    }
}
