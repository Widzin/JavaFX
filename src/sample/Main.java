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

        Person widzin = new Person();
        widzin.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + widzin.firstNameProperty());
            System.out.println("getFirstName():  " + widzin.getFirstName());
        });

        button = new Button("Click me");
        button.setOnAction(e -> widzin.setFirstName("Artur"));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll( button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
