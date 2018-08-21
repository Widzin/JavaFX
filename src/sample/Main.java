package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

        CheckBox chickenBox = new CheckBox("Chicken");
        CheckBox baconBox = new CheckBox("Bacon");

        button = new Button("Order now");
        button.setOnAction(event -> handleOptions(chickenBox, baconBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(chickenBox, baconBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox chickenBox, CheckBox baconBox) {
        String message = "User orders: \n";
        message += checkBox(chickenBox);
        message += checkBox(baconBox);
        message += "---------------------";
        System.out.println(message);
    }

    private String checkBox(CheckBox checkBox) {
        if (checkBox.isSelected())
            return checkBox.getText() + "\n";
        return "";
    }
}
