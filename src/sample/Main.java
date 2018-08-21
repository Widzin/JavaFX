package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;
    private Scene scene;
    private Button button;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");

        TextField input = new TextField();
        button = new Button("Click me");
        button.setOnAction(event -> isInt(input));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(input, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input) {
        try {
            Integer.parseInt(input.getText());
            System.out.println("It is integer.");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("It isn't integer.");
            return false;
        }
    }
}
