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
public class TwoPlayerBoards {
    private Label playerTurn;
    private Label instructions;
    private int[][] atkCoords;
    private int[][] defCoords;
    private Button[][] atkButtons;
    private Button[][] defButtons;
    private Stage stage;
    //this gameboard is a reference for my knowledge.
    public TwoPlayerBoards(Stage stage){
        this.stage = stage;
        atkCoords = new int[8][8]//(how to set them all to zeroes??/)
        defCoords = new int[8][8]//(how to set them all to zeroes??/)
        Button[][] atkButtons = new Button[8][8];
        Button[][] defButtons = new Button[8][8];
    }
    public void scenePlayerOne(){
        BorderPane root = new BorderPane();
        root.setPrefSize(280.0, 280.0);
        Scene twoPlayer = new Scene(root, 300, 300);
        stage.setScene(twoPlayer);

        //makes defense(ships) 8x8 gameboard.
        VBox vertical = new VBox();
        int count = 0;
        for(int across = 0; across<8; across++){
            HBox row = new HBox(8);//creates the hbox.
            for(int down = 0; down <8; down++){
                Button defButton = new Button();//need to size the buttons...
                defButtons[down][across]= defButton;

                defButton.setStyle("-fx-background-color: rgb(255, 255, 255);");
                defButton.setDisable(false);
                //check gofish code
                defButton.setOnAction(event ->
                        /**buttonsyntax**/findButton(defButton);
                        )
                row.getChildren().add(defButton);
            }
            vertical.getChildren().add(row);
        }
        Hbox boards = new Hbox();
        //attack/guess 8.8 gameboards

        VBox vert = new VBox();
        for(int across = 0; across<8; across++){
            HBox row = new HBox(8);//creates the hbox.
            for(int down = 0; down <8; down++){
                Button atkButton = new Button();
                atkGameBoard[down][across] = atkButton;
                atkButton.setStyle("-fx-background-color: rgb(150, 200, 225);");
                atkButton.setDisable(false);
                //check gofish code
                row.getChildren().add(atkButton);
            }
            vert.getChildren().add(row);
        }
        boards.getChildren().add(vertical, vert);//now we have two boards!
        //finish formatting!
        Label playerTurn = new Label("Player One");
        this.playerTurn = playerTurn;
        // playerTurn.setPrefSize(50,50);
        Label instructions = new Label(" ");
        this.instructions=instructions;
        HBox text = new HBox();
        text.getChildren().add(playerTurn, instructions);
        VBox boardText = new VBox();
        boardText.getChildren.add(text, boards);
    }
    public Label getInstructions(){
            return instructions;
    }
    public Label setInstructions(String instructions){
        this.instructions = new Label(instructions);
    }
    public Label getPlayerTurn(){
        return playerTurn;
    }
    public Label setPlayerTurn(String playerTurn){
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
    public int getGameBoardVal(int down, int accross){
        return gameboard[down][accross];
    }
}