package group21.calculator.gui;


import group21.calculator.exceptions.*;
import group21.calculator.operation.Execute;

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
import java.util.ResourceBundle;


/*
* Da fare:
* - Bindings tra -> Stack <-> StackView
*                -> Pane123.. <-> PaneABC..
*
* - Button -> TextArea
* - Button Execute - textProperty of TextArea
* */
public class GuiController implements Initializable {

    private Execute exe;

    public GuiController() {
        this.exe = new Execute();

    }


    @FXML
    private TextField displayArea;



    @FXML
    private Button toNumbersButton;

    @FXML
    private Button toVarButton;



    @FXML
    private Pane mainKeyBoard;

    @FXML
    private Pane view;


    @FXML
    private Pane varKeyBoard;

    @FXML
    private ListView<String> StackView;

    @FXML
    private ListView<String> VarView;



    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button clickedButton) {
            aggiungiTesto(displayArea, clickedButton.getText());
        }
    }

    @FXML
    private void handleClearStackButton(){
            exe.getStack().clearNumber();
            refreshListView();
    }

    @FXML
    private void handleClearTextArearButton() {
        displayArea.setText("");
    }


    @FXML
    void handleToVarButton() {
        mainKeyBoard.setDisable(true);
        mainKeyBoard.setVisible(false);
        varKeyBoard.setDisable(false);
        varKeyBoard.setVisible(true);

    }
    @FXML
    void handleToNumbersButton() {
        mainKeyBoard.setDisable(false);
        mainKeyBoard.setVisible(true);
        varKeyBoard.setDisable(true);
        varKeyBoard.setVisible(false);

    }
    private void exceptionToTextArea(String message) {
        displayArea.clear();
        displayArea.setText(message);
        mainKeyBoard.setDisable(true);
        // Imposta un'animazione per cancellare il messaggio dopo 5 secondi
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(2.5),
                event -> {
                    displayArea.clear();
                    mainKeyBoard.setDisable(false);
                }
        ));
        timeline.play();
        refreshListView();
    }
    // Funzione per aggiungere il testo alla textfield
    private void aggiungiTesto(TextField textField, String text) {
        textField.appendText(text);
    }

    @FXML
    private void handleOverButton(ActionEvent event) {
        try{
            exe.getStack().overNumber();
        } catch (StackIsEmptyException | InsufficientOperandsException ex ) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        refreshListView();
    }

    @FXML
    private void handleExecuteButton () throws Exception {
        try {
            exe.elaboraTextArea(displayArea.getText());
        } catch (InvalidExpressionException | DivisionByZeroException | InsufficientOperandsException |
                 NoValueInVariableException | StackIsEmptyException ex ) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        displayArea.setText("");
        //System.out.println(exe.print());
        refreshListView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainKeyBoard.setDisable(false);
        varKeyBoard.setDisable(true);
        mainKeyBoard.setVisible(true);
        varKeyBoard.setDisable(false);

        toVarButton.setOnAction(event -> handleToVarButton());
        toNumbersButton.setOnAction(event -> handleToNumbersButton());

        refreshListView();
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

    private void refreshListView() {
        if(!exe.getStack().isEmpty()){
            ObservableList<String> items = FXCollections.observableArrayList();
            int count = exe.getStack().getStackSize();

            for(int i = 0; i<count; i++) {
                    items.add(exe.getStack().getNumber(i));
                }

            FXCollections.reverse(items);

            StackView.setItems(items);

        } else {
            ObservableList<String> items = FXCollections.observableArrayList();
            StackView.setItems(items);
        }

    }

    @FXML
    private void handleDropButton() {
        try {
            exe.getStack().dropNumber();
        } catch (StackIsEmptyException ex ) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        refreshListView();
    }

    @FXML
    private void handleDupButton() {
        try{
            exe.getStack().dupNumber();
        } catch (StackIsEmptyException ex ) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        refreshListView();
    }

    @FXML
    private void handleSwapButton() {
        try{
            exe.getStack().swapNumber();
        } catch (StackIsEmptyException | InsufficientOperandsException ex ) {
            exceptionToTextArea(ex.getMessage());
            return;
        }
        refreshListView();
    }

}


