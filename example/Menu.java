package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu extends Main {
    private boolean ruleButtonPress;
    private boolean twoPlayerButtonPress;
    private boolean quitButtonPress;
    private Stage stage;
    private Scene scene;
    public Menu(Stage stage){
        ruleButtonPress= false;
        twoPlayerButtonPress = false;
        quitButtonPress = false;
        this.stage = stage;
    }
/** OPENS MENU:
 * ft quit button,
 * TwoPlayer button,
 * and Rules button**/
    public void sceneMenu(){
        BorderPane root= new BorderPane();
        root.setPrefWidth(280.0);
        root.setPrefWidth(280.0);
        Scene menu = new Scene(root);
        stage.setScene(menu);
        TwoPlayerBoards twoAccess = new TwoPlayerBoards(stage);

        BorderPane menuObjects = new BorderPane();
        Label title = new Label("BATTLESHIP and more!");

        Button quit = new Button("QUIT");
        quit.setOnAction(event -> System.exit(-1));

        Button rule = new Button("RULES");
        rule.setOnAction(event -> rules(menu));
        Button twoPlayer = new Button("TWO PLAYER MODE");
        twoPlayer.setOnAction(event -> twoAccess.scenePlayerOne());
/** sends player over to TwoPlayerBoards**/
        HBox buttonHolder = new HBox(rule, quit, twoPlayer);
        VBox titleHolder = new VBox(title, buttonHolder);
        menuObjects.setCenter(titleHolder);
    }
    /** Rules Stage- no way I'm making a new class for this.**/
    public void rules(Scene menu){
        BorderPane root = new BorderPane();
        root.setPrefSize(280.0, 280.0);
        Scene rules = new Scene(root, 300.0, 300.0);
        String str = "Set up your boards with five ships each.\n "+ "Carrier, Battleship, Cruiser, Submarine, and Destroyer. /n ";
        String strTwo = "On your attack board, click one tile. If you hit your opponents ship, it will turn red. If you miss, it will turn white. \n" + " Your oppoennt will then take their turn. \n " + "This will continue until all five of a player's ships have been destroyed, or a player has surrendered.";
        Label rulesText = new Label(str + strTwo);

        Button back = new Button("BACK");
        back.setOnAction(event -> stage.setScene(menu));
        VBox rulesHolder = new VBox(rulesText, back);
        root.setCenter(rulesHolder);
    }
}