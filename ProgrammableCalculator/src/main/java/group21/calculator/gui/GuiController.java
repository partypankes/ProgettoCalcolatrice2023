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

import java.net.URL;

import java.util.Map;
import javafx.util.Duration;
import java.util.ResourceBundle;

/**
 * This class serves as the controller for the calculator GUI.
 * It manages user interactions with the GUI elements and delegates calculation tasks to the Execute class.
 * The class is responsible for handling button clicks, displaying results, and managing the overall user interface.
 */
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

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded. It initializes the GUI components
     * and sets up event handlers.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.exe = new Execute();

        toVarButton.setOnAction(event -> handleToVarButton());
        toNumbersButton.setOnAction(event -> handleToNumbersButton());
        refreshVarView();
        refreshStackView();
    }

    /**
     * Displays an exception message in the text area and temporarily disables the main keyboard.
     *
     * @param message The message to be displayed in the text area.
     */
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

    /**
     * Refreshes the variable view list with the current variables and their values.
     */
    private void refreshVarView() {
        ObservableList<String> varItems = FXCollections.observableArrayList();

        for (Map.Entry<Character, ComplexNumber> entry : exe.getVar().getVariables().entrySet()) {
            varItems.add(entry.getKey() + ": " + entry.getValue());
        }

        VarView.setItems(varItems);
    }

    /**
     * Refreshes the stack view list with the current stack contents.
     */
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

    /**
     * Appends the given text to the specified TextField. This method is used for adding text to
     * a TextField in the GUI, typically in response to user interactions such as button clicks.
     *
     * @param textField The TextField to which the text will be appended.
     * @param text The text to append to the TextField.
     */
    private void addText(TextField textField, String text) {
        textField.appendText(text);
    }

    /**
     * Handles button clicks on the GUI and appends the corresponding text to the display area.
     *
     * @param event The event that triggered the method call.
     */
    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button clickedButton) {
            addText(displayArea, clickedButton.getText());
        }
    }

    /**
     * Clears the text area when the clear text area button is clicked.
     */
    @FXML
    private void handleClearTextAreaButton() {
        displayArea.setText("");
    }

    /**
     * Removes the last character from the text in the text area when the clear value button is clicked.
     */
    @FXML
    private void handleClearValueButton() {
        String temp = displayArea.getText();

        if (!temp.isEmpty()) {
            String newText = temp.substring(0, temp.length() - 1);
            displayArea.setText(newText);
        }
    }

    /**
     * Switches the view to the variable keyboard when the variable button is clicked.
     */
    @FXML
    private void handleToVarButton() {
        mainKeyBoard.setDisable(true);
        varKeyBoard.setDisable(false);

        mainKeyBoard.setVisible(false);
        varKeyBoard.setVisible(true);

        StackView.setVisible(false);
        VarView.setVisible(true);
    }

    /**
     * Switches the view to the main keyboard when the numbers button is clicked.
     */
    @FXML
    private void handleToNumbersButton() {
        mainKeyBoard.setDisable(false);
        varKeyBoard.setDisable(true);

        mainKeyBoard.setVisible(true);
        varKeyBoard.setVisible(false);

        StackView.setVisible(true);
        VarView.setVisible(false);
    }

    /**
     * Executes the calculation based on the current text in the text area when the execute button is clicked.
     */
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
        refreshVarView();
        refreshStackView();
    }

    /**
     * Clears the stack when the 'clear' button is clicked.
     */
    @FXML
    private void handleClearStackButton() {
        exe.getStack().clearNumber();
        refreshStackView();
    }

    /**
     * Performs the 'over' operation on the stack when the 'over' button is clicked.
     */
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

    /**
     * Drops the top element from the stack when the 'drop' button is clicked.
     */
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

    /**
     * Duplicates the top element of the stack when the 'dup' button is clicked.
     */
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

    /**
     * Swaps the top two elements of the stack when the 'swap' button is clicked.
     */
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


