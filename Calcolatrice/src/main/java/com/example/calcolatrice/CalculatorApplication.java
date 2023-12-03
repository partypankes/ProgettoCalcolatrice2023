package com.example.calcolatrice;

import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Calculator model = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        view.startUI();

    }
}
