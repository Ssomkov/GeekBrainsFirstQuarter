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
    public void sendButtonClick(ActionEvent actionEvent) {
        addInputTextToChatTextArea();
    }

    @FXML
    public void inputTextFieldPressEnter(ActionEvent actionEvent){
        addInputTextToChatTextArea();
    }

    private void addInputTextToChatTextArea() {
        chatTextArea.appendText(inputTextField.getText().concat("\n"));
    }
}
