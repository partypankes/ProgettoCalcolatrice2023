package group21.calculator.gui;


import group21.calculator.operation.Execute;
import group21.calculator.type.ComplexNumber;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

/*
* Da fare:
* - Bindings tra -> Stack <-> StackView
*                -> Pane123.. <-> PaneABC..
*
* - Button -> TextArea
* - Button Execute - textProperty of TextArea
* */
public class GuiController {

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
    void handleToNumbersButton() {
        mainKeyBoard.setDisable(false);
        mainKeyBoard.setVisible(true);
        varKeyBoard.setDisable(true);
        varKeyBoard.setVisible(false);

    }

    // Funzione per aggiungere il testo alla textfield
    private void aggiungiTesto(TextField textField, String text) {
        textField.appendText(text);
    }

    @FXML
    private void handleOverButton(ActionEvent event) {
        exe.getStack().overNumber();
        refreshListView();
    }

    @FXML
    private void handleExcuteButton() throws Exception {
        exe.elaboraTextArea(displayArea.getText());
        displayArea.setText("");
        System.out.println(exe.print());
        refreshListView();
    }


    public void initialize(){
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
        exe.getStack().dropNumber();
        refreshListView();
    }

    @FXML
    private void handleDupButton() {
        exe.getStack().dupNumber();
        refreshListView();
    }

    @FXML
    private void handleSwapButton() {
        exe.getStack().swapNumber();
        refreshListView();
    }

}


