

//** ATTACK!!!
//receive clicked button and coords.
//call battleships, who has a method for this, and will return data.
//based on bool, turn off button and make buttons either red or white.
// if red, mark cord ATTACKED.
// well figure out where htat variable goes...**/



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
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ButtonSyntax extends TwoPlayerBoards{
    private Battleships access;
    private int across;
    private int down;
    private Button currentButton;
    private Stage stage;
    private boolean orientation; //(true = left/right, false = updown)
    public ButtonSyntax(){
        across = 0;
        down = 0;

    }
    public ButtonSyntax(int across, int down, Stage inStage){
       super(inStage);

        this.across = across;
        this.down= down;
    }

    /**this keeps the button were looking at up to date.**/
    public Button buttonFind(Button button, int down, int across){
        this.across = across;
        this.down = down;
        currentButton = button;


    }
    public void setAcross(int across){
        this.across = across;
    }
    public int getAcross(){
        return across;
    }

    public int getDown(){// r/accidentallyfunny
        return down;
    }
    public Button getCurrentButton(){
        return currentButton;
    }
    public void setDown(int down){
        this.down = down;
    }

    public void setOrientation(boolean checker){
        orientation = checker;
        //reminder: true = left/right, false = up/down;


    }
    /**instructions for how buttons and "inside" setup will work
    NOT Labels/Instructions!!!
    ensures buttons will not be clicked multiple times, disables buttons when finished, etc.*/
    //NOTE: confer w group before copy-pasting for other ships.
    public void setupCarrier(int player){
       TwoPlayerBoards access= new TwoPlayerBoards();
        //scene

        BorderPane root = new BorderPane();
        Stage stage = new Stage(root, 200, 200);
        root.setPrefSize(280.0, 280.0);
        Scene orientation = new Scene(root);
        //i need a new created stage and scene above for a popup window.
        Label instructions = new Label("Choose a ship orientation:  ");
        Button width = new Button("Left to right");
        width.setOnAction(event ->
                setOrientation(true)
                );//DNE
        Button height = new Button("Up to down");
        height.setOnAction(event ->
                setOrientation(false);
                access.getScene());
        root.getChildren().addAll(width, height, instructions);
//scene close

        if(this.orientation){//then ships will be set up left right
            access.setInstructions("Press the tile the ship will start at\n going LEFT to RIGHT");

            if (across+4>8){//stops from weird ship placement
                setupCarrier(player);//forces them to go right back to the beginning popup.
            }
            Button[][] carrierArray = new Button[8][8];
            //currentButton... dont forget about it!!!

           Button[][] boardref =  access.getDefButtons();//sets them to blue and tosses into carrier.
               for(int i = 0; i<5; i++) {//placing the four other tiles for the ship automatically.
                   boardref[down][across + i].setStyle("-fx-background-color: rgb(0, 0, 255)");
                   carrierArray[down][across+i] = boardref[down][across+i];//adds to buttonArray
               }
               if(player==1) {
                   Battleships battleships = new Battleships();
                   battleships.setPlayerOneCarrier(carrierArray);
               }
               else{
                   Battleships battleships = new Battleships();
                   battleships.setPlayerOneCarrier(carrierArray);
               }
            //from button to button+4 is turned blue and sent to the array.

        }
        else{//ship set up top bottom.
            if (down+4>8){//stops from weird ship placement
                setupCarrier(player);//forces them to go right back to the beginning popup.
            }
            Button[][] carrierArray = new Button[8][8];
            //currentButton... dont forget about it!!!

            Button[][] boardref =  access.getDefButtons();//sets them to blue and tosses into carrier.
            for(int i = 0; i<5; i++) {//placing the four other tiles for the ship automatically.
                boardref[down+i][across].setStyle("-fx-background-color: rgb(0, 0, 255)");
                carrierArray[down+i][across] = boardref[down+i][across];//adds to buttonArray
            }
            if(player==1) {
                Battleships battleships = new Battleships();
                battleships.setPlayerOneCarrier(carrierArray);
            }
            else{
                Battleships battleships = new Battleships();
                battleships.setPlayerOneCarrier(carrierArray);
            }


        }
    }

    public void setupBattleship(int player){

    }
    public void setUpCruiser(int player){

    }
    public void setUpSubmarine(int player){

    }
    public void setUpDestroyer(int player){

    }

    public void attackClickButtons(){

    }



}