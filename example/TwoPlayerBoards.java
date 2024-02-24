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
    private int[][] gameBoard = {1, 2, 3, 4, 5, 6, 7, 8},
                                {9, 10, 11, 12, 13, 14, 15, 16},
                                {17, 18, 19, 20, 21, 22, 23, 24},
                                {25, 26, 27, 28, 29, 30, 31, 32},
                                {33, 34, 35, 36, 37, 38, 39, 40},
                                {41, 42, 43, 44, 45, 46, 47 ,48},
                                {49, 50, 51, 52, 53, 54, 55, 56},
                                {57, 58, 59, 60, 61, 62, 63, 64};
    private Stage stage;
    //this gameboard is a reference for my knowledge.
    public TwoPlayerBoards(Stage stage){
        this.stage = stage;
    }
    public void scenePlayerOne(){
        BorderPane root = new BorderPane();
        root.setPrefSize(280.0, 280.0);
        Scene twoPlayer = new Scene(root, 300, 300);
        stage.setScene(twoPlayer);

        //makes defense(ships) 8x8 gameboard.
        VBox vertical = new VBox();
        for(int across = 0; across<8; across++){
            HBox row = new HBox(8);//creates the hbox.
            for(int down = 0; down <8; down++){
                Button defButton = new Button();//need to size the buttons...
                        defButton.setStyle("-fx-background-color: rgb(255, 255, 255);");
                      defButton.setDisable(false);
                        //check gofish code
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

    }
    public Label setInstructions(){

    }
    public Label getPlayerTurn(){

    }
    public Label setPlayerTurn(){
        
    }
    public void boardSetupP1(){


    }
    public void boardSetupP2(){

    }
    public int getGameBoardVal(int down, int accross){
       return gameboard[down][accross];
    }
}
