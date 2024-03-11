package org.example;
import javafx.application.Application;
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
/************************************
 * TWOPLAYERBOARDS will SET UP the boards(current mission)
 * and RUN THE TURN-BASED GAME(next mission)
 * might add a coin system and shop
****************************/
public class TwoPlayerBoards {
    private Label playerTurn;
    private Label instructions;
    private Button[][] atkButtons;
    private Button[][] defButtons;
    private Stage stage;
    private Scene scene;
    public TwoPlayerBoards(){
        Label playerTurn = new Label(" ");
        Label instructions = new Label(" ");
        Button[][] atkButtons = new Button[8][8];
        Button[][] defButtons = new Button[8][8];

    }
    //this gameboard is a reference for my knowledge.
    public TwoPlayerBoards(Stage stage){
        Label playerTurn = new Label(" ");
       Label instructions = new Label(" ");
        Button[][] atkButtons = new Button[8][8];
        Button[][] defButtons = new Button[8][8];
        this.stage = stage;
    }

    public Button[][] getDefButtons(){
        return defButtons;
    }
    public Button[][]getAtkButtons(){
        return atkButtons;
    }
    public Stage getStage(){
        return stage;
    }
    public Scene getScene(){
        return scene;
    }
    public void setScene(Scene scene){
        this.scene = scene;
    }
    //sets SCENE
    public void scenePlayerOne(){
         ButtonSyntax access = new ButtonSyntax();
        BorderPane root = new BorderPane();
        root.setPrefSize(280.0, 280.0);
        Scene twoPlayer = new Scene(root, 300, 300);
        stage.setScene(twoPlayer);
        setScene(twoPlayer);//goddammit.DNE
        //makes defense(ships) 8x8 gameboard.
        VBox defBoardBox = new VBox();
        for(int across = 0; across<8; across++){
            HBox row = new HBox(8);
            for(int down = 0; down <8; down++){
                Button defButton = new Button();
                defButton.setPrefSize(100,75);
                defButton.setStyle("-fx-background-color: rgb(255, 255, 255);");
                defButton.setDisable(false);
              /** on click it should send FindButton its button and coords
               * so buttonSyntax can always have the most recent button clicked**/
              final int DOWN = down;
              final int ACROSS = across;//forcing the lambda to work the way i want >:3
                defButton.setOnAction(event -> access.buttonFind(defButton, DOWN, ACROSS));
                defButtons[down][across]= defButton;

                row.getChildren().add(defButton);
            }
            defBoardBox.getChildren().add(row);
        }
        HBox boardHolder = new HBox();
        //attack/guess 8.8 gameboards

        VBox atkBoardBox = new VBox();
        for(int across = 0; across<8; across++){
            HBox row = new HBox(8);//creates the hbox.
            for(int down = 0; down <8; down++){
                Button atkButton = new Button();
                atkButton.setStyle("-fx-background-color: rgb(150, 200, 225);");
                atkButton.setDisable(false);
                /** NOTHING FOR WHAT IT DOES YET.
                 * we dont know. we havent done the game itself.**/
                row.getChildren().add(atkButton);
            }
            atkBoardBox.getChildren().add(row);
        }
        boardHolder.getChildren().addAll(defBoardBox, atkBoardBox);//hbox holding two vboxes

        Label playerTurn = new Label("Player One");
        this.playerTurn = playerTurn;
        // playerTurn.setPrefSize(50,50); maybe
        Label instructions = new Label("Instructions Pending");
        this.instructions=instructions;
        HBox labelText = new HBox();
        labelText.getChildren().addAll(playerTurn, instructions);
        VBox boardAndText = new VBox();
        boardAndText.getChildren().addAll(labelText, boardHolder);
    }


    public Label getInstructions(){
            return instructions;
    }
    public void setInstructions(String instructions){
        this.instructions = new Label(instructions);
    }
    public Label getPlayerTurn(){
        return playerTurn;
    }
    public void setPlayerTurn(String playerTurn){
        this.playerTurn = new Label(playerTurn);
    }

    //setup 1 and 2 to be done AFTER we finish buttonSyntax.
    public void boardSetupP1(){
        ButtonSyntax access = new ButtonSyntax();
        access.setupCarrier(1);
        setInstructions("Place your Battleship\n4 slots");
        access.setupBattleship(1);
        setInstructions("Place your Cruiser\n3 slots");
        access.setUpCruiser(1);
        setInstructions("Place your Submarine\n3 slots");
        access.setUpSubmarine(1);
        setInstructions("Place your Destroyer \n2 slots");
        access.setUpDestroyer(1);

    }
    public void boardSetupP2(){
        ButtonSyntax access = new ButtonSyntax();
        setPlayerTurn("Player Two");
        setInstructions("Place your Carrier\n5 slots");
        access.setupCarrier(2);
        setInstructions("Place your Battleship\n4 slots");
        access.setupBattleship(2);
        setInstructions("Place your Cruiser\n3 slots");
        access.setUpCruiser(2);
        setInstructions("Place your Submarine\n3 slots");
        access.setUpSubmarine(2);
        setInstructions("Place your Destroyer \n2 slots");
        access.setUpDestroyer(2);
    }
    //not actually used yet..
    public int getGameBoardVal(int down, int accross){
       int placeholder = 5;
        return placeholder;
    }

}