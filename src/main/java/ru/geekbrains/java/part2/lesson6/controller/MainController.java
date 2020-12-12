package ru.geekbrains.java.part2.lesson6.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.geekbrains.java.part2.lesson6.client.EchoClient;
import ru.geekbrains.java.part2.lesson6.client.Network;

import java.io.IOException;

public class MainController {

    @FXML
    private ListView userList;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextField inputTextField;
    @FXML
    private Button sendButton;

    private Network network;

    @FXML
    public void appendMessage(String message) {
        chatTextArea.appendText(message);
        chatTextArea.appendText(System.lineSeparator());
        inputTextField.clear();

        inputTextField.requestFocus();
    }

    @FXML
    private void sendMessage() {
        String message = inputTextField.getText();
        appendMessage("Client: " + message);

        try {
            network.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            String errorMessage = "Failed to send message";
            EchoClient.showNetworkError(e.getMessage(), errorMessage);
        }
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
