package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    private static Button yesBtn, noBtn;
    private static boolean answer;
    private static Stage window;

    public static boolean display(String title, String message) {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        yesBtn = new Button("Yes");
        noBtn = new Button("No");

        yesBtn.setOnAction(event -> {
            answer = true;
            window.close();
        });

        noBtn.setOnAction(event -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesBtn, noBtn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    private static void setAnswer(boolean flag) {
        answer = flag;
        window.close();
    }
}
