package group21.calculator.gui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GuiController {

    @FXML
    private Button overButton;

    @FXML
    private Button swapButton;

    @FXML
    private TextField displayArea;

    @FXML
    private Button takeVarButton;

    @FXML
    private Button toNumbersButton;

    @FXML
    private Button toVarButton;

    @FXML
    private Button dropButton;

    @FXML
    private Button pushVarButton;

    @FXML
    private Button exeButton;

    @FXML
    private Pane mainKeyBoard;

    @FXML
    private Button clearValueButton;

    @FXML
    private Pane view;

    @FXML
    private Button clearButton;

    @FXML
    private Button dupButton;

    @FXML
    private Pane varKeyBoard;

    @FXML
    private ListView<?> StackView;

    @FXML
    private Button clearTextAreaButton;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() instanceof Button clickedButton) {
            aggiungiTesto(displayArea, clickedButton.getText());
        }
    }

    // Funzione per aggiungere il testo alla textfield
    private void aggiungiTesto(TextField textField, String text) {
        textField.appendText(text);
    }
}


