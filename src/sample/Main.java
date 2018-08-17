package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window.setTitle("Hello World");




        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
