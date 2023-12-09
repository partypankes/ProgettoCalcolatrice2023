module group21.calculator.programmablecalculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens group21.calculator.gui to javafx.fxml;
    exports group21.calculator.gui;
}