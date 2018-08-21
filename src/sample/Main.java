package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;
    private Scene scene;
    private Button button;
    private ListView<String> listView;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");

        button = new Button("Click me");

        listView = new ListView<>();
        listView.getItems().addAll("Potato", "Corn", "Tomatoe", "Strawberry", "Banana");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> buttonClicked());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClicked() {
        StringBuilder message = new StringBuilder();
        ObservableList<String> food = listView.getSelectionModel().getSelectedItems();
        food.forEach(s -> message.append(s).append("\n"));
        System.out.println(message.toString());
    }
}
