package group21.calculator.gui;

import group21.calculator.exceptions.*;
import group21.calculator.operation.Execute;

import group21.calculator.type.ComplexNumber;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class GuiController implements Initializable {

    private Execute exe;

    @FXML
    private TextField displayArea;

    @FXML
    private Button toNumbersButton;

    @FXML
    private Button toVarButton;

    @FXML
    private Pane mainKeyBoard;

    @FXML
    private Pane varKeyBoard;

    @FXML
    private ListView<String> StackView;

    @FXML
    private ListView<String> VarView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.exe = new Execute();


        toVarButton.setOnAction(event -> handleToVarButton());
        toNumbersButton.setOnAction(event -> handleToNumbersButton());
        refreshVarView();
        refreshStackView();
    }

    private void exceptionToTextArea(String message) {
        displayArea.clear();
        displayArea.setText(message);

        mainKeyBoard.setDisable(true);

        // Imposta un'animazione per cancellare il messaggio dopo 5 secondi
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2.5), event -> {
            displayArea.clear();
            mainKeyBoard.setDisable(false);
        }));

        timeline.play();
        refreshStackView();

    }


    private void refreshVarView() {
        ObservableList<String> varItems = FXCollections.observableArrayList();

        for (Map.Entry<Character, ComplexNumber> entry : exe.getVar().getVariables().entrySet()) {
            varItems.add(entry.getKey() + ": " + entry.getValue());
        }

        VarView.setItems(varItems);

    }

    private void refreshStackView() {
        if (!exe.getStack().isEmpty()) {

            ObservableList<String> items = FXCollections.observableArrayList();
            int count = exe.getStack().getStackSize();

            for (int i = 0; i < count; i++) {
                items.add(exe.getStack().getNumber(i));
            }

            FXCollections.reverse(items);

            StackView.setItems(items);

        } else {

            ObservableList<String> items = FXCollections.observableArrayList();
            StackView.setItems(items);

        }

    }

    // Funzione per aggiungere il testo alla textfield
    private void addText(TextField textField, String text) {
        textField.appendText(text);

    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button clickedButton) {
            addText(displayArea, clickedButton.getText());
        }
    }


    @FXML
    private void handleClearTextAreaButton() {
        displayArea.setText("");
    }

    @FXML
    private void handleClearValueButton() {
        String temp = displayArea.getText();

        if (!temp.isEmpty()) {
            // Rimuove l'ultimo carattere dalla stringa
            String newText = temp.substring(0, temp.length() - 1);

            displayArea.setText(newText);
        }

    }

    @FXML
    private void handleToVarButton() {
        mainKeyBoard.setDisable(true);
        varKeyBoard.setDisable(false);

        mainKeyBoard.setVisible(false);
        varKeyBoard.setVisible(true);

        StackView.setVisible(false);
        VarView.setVisible(true);

    }


    @FXML
    private void handleToNumbersButton() {
        mainKeyBoard.setDisable(false);
        varKeyBoard.setDisable(true);

        mainKeyBoard.setVisible(true);
        varKeyBoard.setVisible(false);

        StackView.setVisible(true);
        VarView.setVisible(false);

    }

    @FXML
    private void handleExecuteButton() {
        try {
            exe.elaborateTextArea(displayArea.getText());
        } catch (InvalidExpressionException | DivisionByZeroException | InsufficientOperandsException |
                 NoValueInVariableException | StackIsEmptyException ex) {
            exceptionToTextArea(ex.getMessage());
            return;
        }

        displayArea.setText("");
        //System.out.println(exe.print());

        refreshVarView();
        refreshStackView();
    }

    @FXML
    private void handleClearStackButton() {
        exe.getStack().clearNumber();
        refreshStackView();
    }

    @FXML
    private void handleOverButton() {
        try {
            exe.getStack().overNumber();
        } catch (StackIsEmptyException | InsufficientOperandsException ex) {
            exceptionToTextArea(ex.getMessage());
            return;
        }

        refreshStackView();

    }

    @FXML
    private void handleDropButton() {
        try {
            exe.getStack().dropNumber();
        } catch (StackIsEmptyException ex) {

            exceptionToTextArea(ex.getMessage());
            return;
        }

        refreshStackView();
    }

    @FXML
    private void handleDupButton() {
        try {
            exe.getStack().dupNumber();
        } catch (StackIsEmptyException ex) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        refreshStackView();
    }

    @FXML
    private void handleSwapButton() {
        try {
            exe.getStack().swapNumber();
        } catch (StackIsEmptyException | InsufficientOperandsException ex) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        refreshStackView();
    }

}


