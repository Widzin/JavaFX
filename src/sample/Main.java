package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;
    private Scene scene;
    private BorderPane layout;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");

        layout = new BorderPane();
        prepareFileMenu();

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void prepareFileMenu() {
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(new MenuItem("New file"));
        fileMenu.getItems().add(new MenuItem("Open file"));
        fileMenu.getItems().add(new MenuItem("Save file"));
        fileMenu.getItems().add(new MenuItem("Exit"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        layout.setTop(menuBar);
    }
}
