package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;
    private Scene scene;


    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");

        ChoiceBox<String> meets = new ChoiceBox<>();
        meets.getItems().addAll("Bacon", "Chicken", "Ham");
        meets.setValue("Bacon");
//        meets.setOnAction(event -> System.out.println(meets.getValue()));
        meets.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(meets);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
