package org.example.lab11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void send(){
        System.out.println("SEND");
        String msg=textField.getText();
        textArea.appendText(msg+"\n");
        textField.clear();
    }
}