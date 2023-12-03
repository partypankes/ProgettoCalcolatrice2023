package com.example.calcolatrice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorController {
    private Calculator model;
    private CalculatorView view;

    public CalculatorController(Calculator model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Aggiungi un gestore di eventi per il pulsante di uguale
        Button equalButton = view.getButton("=");
        equalButton.setOnAction(e -> {
            String input = view.getInputTextArea().getText();
            model.performOperation(input);
            updateStackListView();
        });

        // Aggiungi un gestore di eventi per gli altri tasti
        for (int row = 1; row <= view.getButtonLabels().length; row++) {
            for (int col = 0; col < view.getButtonLabels()[row - 1].length; col++) {
                Button button = view.getButton(view.getButtonLabels()[row - 1][col]);
                button.setOnAction(getButtonHandler(button));
            }
        }
    }

    private void updateStackListView() {
        List<String> stackItems = model.getStack().stream()
                .map(ComplexNumber::toString)
                .collect(Collectors.toList());

        view.getStackListView().getItems().setAll(stackItems);
    }

    private EventHandler<ActionEvent> getButtonHandler(Button button) {
        return e -> {
            String buttonText = button.getText();
            view.getInputTextArea().appendText(buttonText);
            updateStackListView(); // Aggiorna la ListView dello stack dopo ogni numero o operazione
        };
    }
}
