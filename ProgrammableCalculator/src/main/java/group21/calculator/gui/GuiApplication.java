package group21.calculator.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * This class is the main entry point for the graphical user interface (GUI) of the calculator.
 * It extends the JavaFX Application class, providing the necessary framework to create and show
 * the GUI. This class handles the initialization and configuration of the main application window.
 */
public class GuiApplication extends Application  {

    /**
     * Starts the JavaFX application. This method is called after the init method has returned, and
     * after the system is ready for the application to begin running.
     *
     * @param stage The primary stage for this application, onto which the application scene can be set.
     * @throws IOException If there is an issue loading the FXML file for the GUI.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiApplication.class.getResource("gui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("ProgrammableCalculator");
        stage.setResizable(false);
        stage.getIcons().add(new Image("icon.png"));

        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main entry point for all JavaFX applications. This method launches the JavaFX application.
     *
     * @param args The command line arguments passed to the application. Not used in this implementation.
     */
    public static void main(String[] args) {
        launch();
    }
}