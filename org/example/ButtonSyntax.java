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

    public ButtonSyntax(){
        across = 0;
        down = 0;

    }
    public ButtonSyntax(int across, int down){
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
    public void setupCarrier(int player){
        boolean colored = false;
        ArrayList<Integer> carrierList = new ArrayList<>();
        int i = 0;
        do{
            if(i>1){//base cords. will ensure ships are only lines, no diagnal.
                if((across==carrierList.get(i))||(across==carrierList.get(i)+1)||(across==carrierList.get(i)-1){
                        if((down==carrierList.get(i-1))||(down==carrierList.get(i-1))+1||(down==carrierList.get(i-1))-1){
                       //above just makes sure they're connected.
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
            }
            else{
                i--;
            }
        }while(i<5);

        int[][] arrayCarrier = new int[8][8];//switch to an array to send out.
        for(int j = 0; j<5; j++){
            int row = carrierList.get(j);
            int col = carrierList.get(j+1);
            int placeholder = arrayCarrier[col][row];//yes thats right! down, across! finally!
        }
        if (player==1){
            setPlayerOneCarrier(arrayCarrier);
        }
        else{
            setPlayerTwoCarrier(arrayCarrier);
        }
        disableButtons(arrayCarrier);
    }
    public void setupBattleship(int player){
        boolean colored = false;
        ArrayList<Integer> battleshipList = new ArrayList<>();
        int i = 0;
        do{
            if(i>1){//base cords. will ensure ships are only lines, no diagnal.
                if((across==battleshipList.get(i))||(across==battleshipList.get(i)+1)||(across==battleshipList.get(i)-1){
                    if((down==battleshipList.get(i-1))||(down==battleshipList.get(i-1)+1)||(down==battleshipList.get(i-1)-1)){
                        //above just makes sure they're connected.
                        button = buttonFind();
                        if (colored) {
                            button.setStyle("-fx-background-color: rgb(255, 0, 0);");
                            battleshipList.add(i, (Integer) across);//across is always gonna be even
                            battleshipList.add(i + 1, (Integer) down);//odd
                            colored = true;
                        } else {
                            button.setStyle("-fx-background-color: rgb(0, 0, 0);");
                            battleshipList.remove(i);
                            battleshipList.remove(i + 1);
                            colored = false;
                            i--;//forces the player to choose again.
                        }
                    }
                }
            }
            else{
                i--;
            }
        }while(i<4);

        int[][] arrayBattleship = new int[8][8];//switch to an array to send out.
        for(int j = 0; j<4; j++){
            int row = battleshipList.get(j);
            int col = battleshipList.get(j+1);
           int placeholder = arrayBattleship[col][row];//yes thats right! down, across! finally!
        }
        if (player==1){
            setPlayerOneBattleship(arrayBattleship);
        }
        else{
            setPlayerTwoBattleship(arrayBattleship);
        }
        disableButtons(arrayBattleship);
    }
    public void disableButtons(int[][] coords){

    }
    public void setUpCruiser(int player){
        boolean colored = false;
        ArrayList<Integer> cruiserList = new ArrayList<>();
        int i = 0;
        do{
            if(i>1){//base cords. will ensure ships are only lines, no diagnal.
                if((across==cruiserList.get(i))||(across==cruiserList.get(i)+1)||(across==cruiserList.get(i)-1){
                    if((down==cruiserList.get(i-1))||(down==cruiserList.get(i-1)+1)||(down==cruiserList.get(i-1)-1)){
                        //above just makes sure they're connected.
                        button = buttonFind();
                        if (colored) {
                            button.setStyle("-fx-background-color: rgb(255, 0, 0);");
                            cruiserList.add(i, (Integer) across);//across is always gonna be even
                            cruiserList.add(i + 1, (Integer) down);//odd
                            colored = true;
                        } else {
                            button.setStyle("-fx-background-color: rgb(0, 0, 0);");
                            cruiserList.remove(i);
                            cruiserList.remove(i + 1);
                            colored = false;
                            i--;//forces the player to choose again.
                        }
                    }
                }
            }
            else{
                i--;
            }
        }while(i<3);

        int[][] arrayCruiser = new int[8][8];//switch to an array to send out.
        for(int j = 0; j<3; j++){
            int row = cruiserList.get(j);
            int col = cruiserList.get(j+1);
            int placeholder = arrayCruiser[col][row];
        }
        if (player==1){
            setPlayerOneCruiser(arrayCruiser);
        }
        else{
            setPlayerTwoCruiser(arrayCruiser);
        }
        disableButtons(arrayCarrier);
    }
    public void setUpSubmarine(int player){
        boolean colored = false;
        ArrayList<Integer> subList = new ArrayList<>();
        int i = 0;
        do{
            if(i>1){//base cords. will ensure ships are only lines, no diagnal.
                if((across==subList.get(i))||(across==subList.get(i)+1)||(across==subList.get(i)-1){
                    if((down==subList.get(i-1))||(down==subList.get(i-1)+1)||(down==subList.get(i-1)-1)){
                        //above just makes sure they're connected.
                        button = buttonFind();
                        if (colored) {
                            button.setStyle("-fx-background-color: rgb(255, 0, 0);");
                            subList.add(i, (Integer) across);//across is always gonna be even
                            subList.add(i + 1, (Integer) down);//odd
                            colored = true;
                        } else {
                            button.setStyle("-fx-background-color: rgb(0, 0, 0);");
                            subList.remove(i);
                            subList.remove(i + 1);
                            colored = false;
                            i--;//forces the player to choose again.
                        }
                    }
                }
            }
            else{
                i--;
            }
        }while(i<3);

        int[][] arraySub = new int[8][8];//switch to an array to send out.
        for(int j = 0; j<3; j++){
            int row = subList.get(j);
            int col = subList.get(j+1);
            int placeholder = arraySub[col][row];
        }
        if (player==1){
            setPlayerOneSubmarine(arraySub);
        }
        else{
            setPlayerTwoSubmarine(arraySub);
        }
        disableButtons(arraySub);
    }
    public void setUpDestroyer(int player){
        boolean colored = false;
        ArrayList<Integer> destroyerlist = new ArrayList<>();
        int i = 0;
        do{
            if(i>1){//base cords. will ensure ships are only lines, no diagnal.
                if((across==destroyerlist.get(i))||(across==destroyerlist.get(i)+1)||(across==destroyerlist.get(i)-1){
                    if((down==destroyerlist.get(i-1))||(down==destroyerlist.get(i-1)+1)||(down==destroyerlist.get(i-1)-1)){
                        //above just makes sure they're connected.
                        button = buttonFind();
                        if (colored) {
                            button.setStyle("-fx-background-color: rgb(255, 0, 0);");
                            destroyerlist.add(i, (Integer) across);//across is always gonna be even
                            destroyerlist.add(i + 1, (Integer) down);//odd
                            colored = true;
                        } else {
                            button.setStyle("-fx-background-color: rgb(0, 0, 0);");
                            destroyerlist.remove(i);
                            destroyerlist.remove(i + 1);
                            colored = false;
                            i--;//forces the player to choose again.
                        }
                    }
                }
            }
            else{
                i--;
            }
        }while(i<2);

        int[][] arrayDestroyer = new int[8][8];//switch to an array to send out.
        for(int j = 0; j<2; j++){
            int row = destroyerlist.get(j);
            int col = destroyerlist.get(j+1);
            int placeholder = arrayDestroyer[col][row];
        }
        if (player==1){
            setPlayerOneDestroyer(arrayDestroyer);
        }
        else{
            setPlayerTwoDestroyer(arrayDestroyer);
        }
        disableButtons(arrayDestroyer);
    }
/** disableButtons for button Disablement**/
/** NOTE: CHECK TO SEE IF THIS WILL DISABLE ALL THE BUTTONS. I ONLY WANT SPECIFIC BUTTONS**/
    public void disableButtons(int[][] coords){
        //how do we disable teh buttons...?ah. .setDisable()
        for (int column = 0; column<coords.length;column++){
            for (int row = 0; row<coords[column].length;row++){
                if (coords[column][row]!=-1){//-1 will represent an empty cell
                    coords[column][row].setDisable(true);
                }
            }
        }
    }

    public void attackClickButtons(){

    }
}