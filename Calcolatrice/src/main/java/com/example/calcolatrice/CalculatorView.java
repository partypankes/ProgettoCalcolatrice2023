package com.example.calcolatrice;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Set;
import java.util.stream.Collectors;

public class CalculatorView {
    private TextArea inputTextArea;
    private ListView<String> stackListView;
    private GridPane gridPane;

    private String[][] buttonLabels = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"0", "=", "/", "sqrt"},
            {"clear", "drop", "dup", "swap"},
            {"a", "b", "c", "d"},
            {"e", "f", "g", "h"},
            {"i", "j", "k", "l"},
            {"m", "n", "o", "p"},
            {"q", "r", "s", "t"},
            {"u", "v", "w", "x"},
            {"y", "z", "+x", "-x"}
    };

    public CalculatorView() {
        configureUI();
    }
    public String[][] getButtonLabels() {
        return buttonLabels;
    }
    private void configureUI() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);

        // Aggiungi una TextArea per visualizzare i numeri e le operazioni sopra i pulsanti
        inputTextArea = new TextArea();
        inputTextArea.setEditable(false);
        inputTextArea.setMinHeight(50);
        inputTextArea.setMaxHeight(50);
        gridPane.add(inputTextArea, 0, 0, buttonLabels[0].length, 1);

        // Aggiungi una ListView per visualizzare lo Stack a destra
        stackListView = new ListView<>();
        stackListView.setMinWidth(150);
        stackListView.setMaxWidth(150);
        gridPane.add(stackListView, buttonLabels[0].length, 0, 1, buttonLabels.length);

        for (int row = 1; row <= buttonLabels.length; row++) {
            for (int col = 0; col < buttonLabels[row - 1].length; col++) {
                Button button = new Button(buttonLabels[row - 1][col]);
                button.setMinSize(50, 50);
                // Non c'è bisogno di gestori di eventi qui, verranno gestiti dal Controller
                gridPane.add(button, col, row);
            }
        }
    }

    public void startUI() {
        Platform.runLater(() -> {
            Stage primaryStage = new Stage();
            configureUI();

            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setTitle("Calculator");
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }

    public TextArea getInputTextArea() {
        return inputTextArea;
    }

    public ListView<String> getStackListView() {
        return stackListView;
    }

    public Button getButton(String label) {
        Set<Node> buttonSet = gridPane.lookupAll(".button");
        ObservableList<Node> buttons = FXCollections.observableArrayList(buttonSet);

        for (Node node : buttons) {
            if (node instanceof Button && ((Button) node).getText().equals(label)) {
                return (Button) node;
            }
        }
        return null;
    }
}
