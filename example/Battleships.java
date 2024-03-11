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
public class Battleships extends ButtonSyntax{
    private Button[][] oneCarrier;
    private Button[][] twoCarrier;
    private Button[][] oneBattleship;
    private Button[][] twoBattleship;
    private Button[][] oneCruiser;
    private Button[][] twoCruiser;
    private Button[][] oneSubmarine;
    private Button[][] twoSubmarine;
    private Button[][] oneDestroyer;
    private Button[][] twoDestroyer;
    public Battleships(){
    }
    //p1
    public void setPlayerOneCarrier(Button[][] coords) {//5
        oneCarrier = coords;
    }
    public void setPlayerOneBattleship(Button[][] coords){//4
        oneBattleship = coords;
    }
    public void setPlayerOneCruiser(Button[][] coords) {//3
        oneCruiser = coords;
    }
    public void setPlayerOneSubmarine(Button[][] coords) {//3
        oneSubmarine = coords;
    }
    public void setPlayerOneDestroyer(Button[][] coords) {//2
        oneDestroyer = coords;
    }
    public Button[][] getPlayerOneCarrier() {//5
        return oneCarrier;
    }
    public Button[][] getPlayerOneBattleship() {//4
        return oneBattleship;
    }
    public Button[][] getPlayerOneCruiser() {//3
        return oneCruiser;
    }
    public Button[][] getPlayerOneSubmarine(){//3
        return oneSubmarine;
    }
    public Button[][] getPlayerOneDestroyer() {//2
        return oneDestroyer;
    }
    //p2
    public void setPlayerTwoCarrier(Button[][] coords) {//5
        twoCarrier = coords;
    }
    public void setPlayerTwoBattleship(Button[][] coords){//4
        twoBattleship = coords;
    }
    public void setPlayerTwoCruiser(Button[][] coords) {//3
        twoCruiser = coords;
    }
    public void setPlayerTwoSubmarine(Button[][] coords) {//3
        twoSubmarine = coords;
    }
    public void setPlayerTwoDestroyer(Button[][] coords) {//2
        twoDestroyer = coords;
    }

    public Button[][] getPlayerTwoCarrier() {//5
        return twoCarrier;
    }
    public Button[][] getPlayerTwoBattleship() {//4
        return twoBattleship;
    }
    public Button[][] getPlayerTwoCruiser(){//3
        return twoCruiser;
    }
    public Button[][] getPlayerTwoSubmarine() {//3
        return twoSubmarine;
    }
    public Button[][] getPlayerTwoDestroyer() {//2
        return twoDestroyer;
    }
    public boolean matchCoordsOne(int down, int across){// ah yes my favorite not-working method.
        boolean carrier = false;
        boolean battleship = false;
        boolean cruiser = false;
        boolean submarine = false;
        boolean destroyer = false;
        TwoPlayerBoards access = new TwoPlayerBoards();

        Button[][] testButtons = new Button[8][8];
        Button button = new Button();
        button.setStyle("-fx-background-color: rgb(255, 0, 0);");
        testButtons[down][across] = button;
        if (twoCarrier[down][across]==(testButtons[down][across])) {
            carrier = true;
        }
        if (twoBattleship[down][across]==(testButtons[down][across])) {
            battleship = true;
        }
        if (twoCruiser[down][across]==(testButtons[down][across])) {
            cruiser = true;
        }
        if (twoSubmarine[down][across]==(testButtons[down][across])) {
            submarine = true;
        }
        if (twoDestroyer[down][across]==(testButtons[down][across])) {
            destroyer = true;
        }
        ///////////
        if (carrier){
            return carrier;
        } else if(battleship) {
            return battleship;
        } else if (cruiser) {
            return cruiser;
        }else if (submarine) {
            return submarine;
        } else if (destroyer){
            return destroyer;
        }else{
            return carrier;//itll just return false. same thing.
        }
    }
}