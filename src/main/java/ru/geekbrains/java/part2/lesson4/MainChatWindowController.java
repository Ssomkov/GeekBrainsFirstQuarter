package ru.geekbrains.java.part2.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainChatWindowController {

    @FXML
    private ListView userList;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextField inputTextField;
    @FXML
    private Button sendButton;

    @FXML
    private void addInputTextToChatTextArea() {
        chatTextArea.appendText(inputTextField.getText());
        chatTextArea.appendText(System.lineSeparator());
        inputTextField.clear();
    }
}
