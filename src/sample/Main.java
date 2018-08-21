package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage window;
    private TreeView<String> treeView;
    private TreeItem<String> marvel, hulk, thor;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hello World");

        marvel = new TreeItem<>("Marvel");
        marvel.setExpanded(true);

        hulk = makeBranch("Hulk", marvel);
        makeBranch("Bruce", hulk);
        makeBranch("Banner", hulk);

        thor = makeBranch("Thor", marvel);
        makeBranch("Odinson", thor);

        treeView = new TreeView<>(marvel);
        treeView.setShowRoot(true);

        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String text, TreeItem<String> parent) {
        TreeItem<String> children = new TreeItem<>(text);
        children.setExpanded(true);
        parent.getChildren().add(children);
        return children;
    }
}
