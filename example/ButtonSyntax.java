//** BUTTON SYNTAX!
// this will handle setup and attack. but setup first...
// setupOne is going to call receive the coordinates when it is called, along with the specific button pressed.
// setupOne is going to store those coords in an arraylist.
// setup one's next received coords must be the same x or y, or else it does not register.
// when setupOne's first ship is done, turn off those buttons. transport arraylist data to a double array
// hand it off to the respective ship to had off to Battleships.
// repeat until all p1 ships are done.
// begin p2**/

//** ATTACK!!!
//receive clicked button and coords.
//call battleships, who has a method for this, and will return data.
//based on bool, turn off button and make buttons either red or white.
// if red, mark cord ATTACKED.
// well figure out where htat variable goes...**/



package org.example;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class ButtonSyntax extends TwoPlayerBoards{
    private Battleships access;
    private int across;
    private int down;
    private Stage stage;
    public ButtonSyntax(Stage stage){
        super(stage);
        across = 0;
        down = 0;

    }
    public ButtonSyntax(int across, int down, Stage stage){
        super(stage);
        this.across = across;
        this.down= down;
    }
    //buttonFind is going to call receive the coordinates when it is called, along with the specific button pressed.
// setupOne is going to store those coords in an arraylist.
// setup one's next received coords must be the same x or y, or else it does not register.
// when setupOne's first ship is done, turn off those buttons. transport arraylist data to a double array
// hand it off to the respective ship to had off to Battleships.
// repeat until all p1 ships are done.
// begin p2**/

    /**this keeps the button were looking at up to date.**/
    public Button buttonFind(int across, int down, Button button){
     this.across = across;
     this.down = down;
     return button;
    }
    public void setAcross(int across){
        this.across = across;
    }
    public int getAcross(){
    return across;
    }

    //heres comes the rough one...
    public int getDown(){// r/accidentallyfunny
        return down;
    }

    public void setDown(int down){
        this.down = down;
    }
    public void setupOne(Button button, int player){
        boolean colored = false;
        ArrayList<Integer> carrierList = new ArrayList<>();
        int i = 0;
        do{
            if(i>1){//base cords. will ensure ships are only lines, no diagnal.
                if((across==carrierList.get(i))||(down==carrierList.get(i-1)){//
                    button = buttonFind();
                    if (colored) {
                        button.setStyle("-fx-background-color: rgb(255, 0, 0);");
                        carrierList.add(i, (Integer) across);//across is always gonna be even
                        carrierList.add(i + 1, (Integer) down);//odd
                        colored = true;
                    } else {
                        button.setStyle("-fx-background-color: rgb(0, 0, 0);");
                        carrierList.remove(i);
                        carrierList.remove(i + 1);
                        colored = false;
                        i--;//forces the player to choose again.
                    }
                }
            }
            else{
                i--;
                }
        }while(i<5);

            array int[][] arrayCarrier = new array[8][8];//switch to an array to send out.
            for(int j = 0; j<5; j++){
                int row = carrierList.get(j);
                int col = carrierList.get(j+1);
                placeholder = arrayCarrier[col][row];//yes thats right! down, across! finally!
            }
            if (player==1){
                setPlayerOneCarrier(arrayCarrier);
            }
            else{
                setPlayerTwoCarrier(arrayCarrier);
            }
            disableButtons(arrayCarrier);
    }
    public void disableButtons(int[][] coords){

    }

    public void attackClickButtons(){

    }
}
