package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;
    private Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label label1 = new Label("Welcome to the first scene.");
        Button button1 = new Button("Go to the second scene.");
        button1.setOnAction(event -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200, 200);

        Button button2 = new Button("Go to the first scene.");
        button2.setOnAction(event -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("Title here");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
