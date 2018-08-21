package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;
    private Scene scene;
    private Button button;
    private ComboBox<String> comboBox;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");
        button = new Button("Click me");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Matrix",
                "Shrek",
                "Red Riding Hood",
                "Zootopia"
        );
        comboBox.setPromptText("Choose a movie");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
