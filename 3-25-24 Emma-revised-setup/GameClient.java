package edu.sdccd.cisc191.template;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class GameClient {
    private Label hostNameMessage = new Label("Host name:");
    private Label portNameMessage = new Label("Port name:");
    private TextField hostNameTextField = new TextField();
    private TextField portNameTextField = new TextField();

    private String hostName;
    private int portName;


    private HBox buttons = new HBox(15, hostNameMessage, hostNameTextField, portNameMessage, portNameTextField);

    public GameClient() throws IOException {
        buttons.setAlignment(Pos.CENTER);
        hostNameTextField.setOnKeyPressed( evt -> {
            if ( evt.getCode().equals(KeyCode.ENTER) ) {
                portNameTextField.requestFocus();
                hostName = hostNameTextField.getText();
            }
        } );

        portNameTextField.setOnKeyPressed( evt -> {
            if ( evt.getCode().equals(KeyCode.ENTER) ) {
                portName = Integer.parseInt( portNameTextField.getText() );
                try {
                    Socket connection = new Socket(hostName, portName);
                    Label message = new Label("Connection successful!");
                    message.setStyle("-fx-font-size: 20px");
                    buttons.getChildren().setAll(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } );

    }

    public HBox getHBox() {
        return buttons;
    }
}