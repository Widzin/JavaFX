package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Hello World");

        HBox topMenu = new HBox();
        Button fileBtn = new Button("File");
        Button editBtn = new Button("Edit");
        Button viewBtn = new Button("View");
        topMenu.getChildren().addAll(fileBtn, editBtn, viewBtn);

        VBox leftMenu = new VBox();
        Button dBtn = new Button("D");
        Button eBtn = new Button("E");
        Button fBtn = new Button("F");
        leftMenu.getChildren().addAll(dBtn, eBtn, fBtn);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 300, 275);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
