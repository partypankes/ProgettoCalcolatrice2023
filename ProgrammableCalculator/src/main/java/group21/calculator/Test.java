package group21.calculator;

import group21.calculator.operation.Execute;
import group21.calculator.type.ComplexNumber;
import group21.calculator.type.StackNumber;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//POSSIBILE IDEA -> stack su GUI non visibile fino alla fine della stringa delle operazioni
// array di operazioni da swappare prima di eseguirle
public class Test  {

    public static void main(String[] args) throws Exception  {
        String input = "3+0j";

        System.out.println(ComplexNumber.complexParse(input));

        String[] str1 = {"3+2j", "3-2j", "-3+2j", "-3-2j", "3", "-3", "-2j", "2j", "0+2j", "0-2j", "3-0j", "3+0j", "0-2","0+2" };
        Execute exe = new Execute();

    }
}
