package sample;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        IntegerProperty x = new SimpleIntegerProperty(5);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));

        button = new Button("Click me");
        button.setOnAction(e -> {
            x.setValue(x.getValue() + 2);
            System.out.println("X: " + x.getValue());
            System.out.println("Y: " + y.getValue());
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll( button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
