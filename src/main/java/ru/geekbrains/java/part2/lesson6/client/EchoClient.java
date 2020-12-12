package ru.geekbrains.java.part2.lesson6.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import ru.geekbrains.java.part2.lesson6.controller.MainController;

public class EchoClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EchoClient.class.getResource("/fxml/javaFXLesson6Config.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Simple chat");
        primaryStage.setScene(new Scene(root, 660, 380));
        primaryStage.setResizable(false);
        primaryStage.show();

        Network network = new Network();
        if (!network.connect()) {
            showNetworkError("", "Failed to connect to server");
        }

        MainController viewController = loader.getController();
        viewController.setNetwork(network);

        network.waitMessages(viewController);
    }

    public static void showNetworkError(String errorDetails, String errorTitle) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Network Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorDetails);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
