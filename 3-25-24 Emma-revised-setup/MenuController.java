package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.GameClient;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;

import java.io.IOException;

public class MenuController {
    private boolean isOnline = false;
    private boolean isSpecial = false;
    private boolean isCredit = false;
    private static ImageView LOGO = new ImageView( new Image("https://static.wikia.nocookie.net/logopedia/images/8/8c/4e173fe993fef3933e455d4a2fa85d66.png/revision/latest?cb=20180225015935", 900, 271.5, true, true) );
    private static HBox buttons = new HBox(30);
    private static VBox root = new VBox(LOGO, buttons);

    public VBox setupRoot() {
        Button local = new Button("Local");
        styleButton(local);
        Button online = new Button("Online");
        styleButton(online);
        Button credits = new Button("Credits!");
        styleButton(credits);

        Button regular = new Button("Regular Mode");
        styleButton(regular);
        Button special = new Button("Special Mode");
        styleButton(special);
        Button mainMenu = new Button ("Main Menu");
        styleButton(mainMenu);

        Button createLobby = new Button("Create Lobby");
        styleButton(createLobby);
        Button joinLobby = new Button("Join Lobby");
        styleButton(joinLobby);


        local.setOnAction( evt -> {
            changeButtons(regular, special, mainMenu);
            regular.setOnAction(evt -> {
                //something to send to local play
                stage.setScene(LocalPlayerBoards);
            })
        } );

        online.setOnAction( evt -> {
            changeButtons(regular, special, mainMenu);
            isOnline = true;
        } );

        credits.setOnAction( evt -> {
            displayCredits(mainMenu);
        } );


        mainMenu.setOnAction( evt -> {
            changeButtons(local, online, credits);
            if (isOnline)
                isOnline=false;

            if (isCredit) {
                isCredit=false;
                root.getChildren().setAll(LOGO, buttons);
            }
        } );

        regular.setOnAction( evt -> {
            if(isOnline) {
                changeButtons(createLobby, joinLobby, mainMenu);
            }
            else {
                //code to start setting up Battleships local and regular
            }
        } );

        special.setOnAction( evt -> {
            if(isOnline) {
                isSpecial = true;
                changeButtons(createLobby, joinLobby, mainMenu);
            }
            else {
                isSpecial = true;
                //code to start setting up Battleships special and local
            }
        } );

        createLobby.setOnAction( evt -> {
            GameServer server = null;
            try {
                server = new GameServer();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            buttons.getChildren().setAll( server.getPortMessage() );
        } );

        joinLobby.setOnAction( evt -> {
            GameClient client = null;
            try {
                client = new GameClient();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            root.getChildren().setAll(LOGO, client.getHBox() );
        } );


        changeButtons(local, online, credits);
        buttons.setAlignment(Pos.CENTER);
        buttons.setStyle("-fx-pdding: 30px");
        root.setAlignment(Pos.CENTER);
        return root;
    }

    public void changeButtons(Button button1, Button button2, Button button3) {
        buttons.getChildren().setAll(button1, button2, button3);
    }

    public void displayCredits(Button mainMenu) {
        isCredit = true;
        Label creditsMessage = new Label("Credits will be added later!");
        creditsMessage.setStyle("-fx-font-size: 30px");
        buttons.getChildren().setAll(mainMenu);
        root.getChildren().setAll(creditsMessage, buttons);
    }

    public void styleButton(Button button1) {
        buttons.setHgrow(button1, Priority.ALWAYS);
        button1.setStyle("-fx-font-family: 'Comic Sans MS' ");
        button1.setMaxWidth(200);
        button1.setMinWidth( button1.getPrefWidth() );
        button1.setStyle("-fx-font-size: 20px");
    }
}