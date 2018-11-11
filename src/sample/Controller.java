package sample;

import javafx.scene.control.Button;

public class Controller {

    public Button btn;

    public void clickBtn() {
        System.out.println("The button has been clicked.");
        btn.setText("Stop click me.");
    }
}
