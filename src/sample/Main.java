package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
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
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(prepareFileMenu(), prepareEditMenu());
        layout.setTop(menuBar);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private Menu prepareFileMenu() {
        Menu fileMenu = new Menu("_File");

        MenuItem newItem = new MenuItem("New...");
        newItem.setOnAction(e -> System.out.println("Create a new file..."));
        fileMenu.getItems().add(newItem);

        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        return fileMenu;
    }

    private Menu prepareEditMenu() {
        Menu editMenu = new Menu("_Edit");

        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setDisable(true);
        editMenu.getItems().add(pasteItem);

        return editMenu;
    }
}
