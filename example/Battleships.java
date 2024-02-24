package org.example;

public class Battleships extends ButtonSyntax{
    private int[][] oneCarrier;
    private int[][] twoCarrier;
    private int[][] oneBattleship;
    private int[][] twoBattleship;
    private int[][] oneCruiser;
    private int[][] twoCruiser;
    private int[][] oneSubmarine;
    private int[][] twoSubmarine;
    private int[][] oneDestroyer;
    private int[][] twoDestroyer;
    public Battleships(){
    }
//p1
    public void setPlayerOneCarrier(int[][] coords) {//5
        oneCarrier = coords;
    }
    public void setPlayerOneBattleship(int[][] coords){//4
        oneBattleship = coords;
    }
    public void setPlayerOneCruiser(int[][] coords) {//3
        oneCruiser = coords;
    }
    public void setPlayerOneSubmarine(int[][] coords) {//3
        oneSubmarine = coords;
    }
    public void setPlayerOneDestroyer(int[][] coords) {//2
        oneDestroyer = coords;
    }
    public int[][] getPlayerOneCarrier() {//5
    return oneCarrier;
    }
    public int[][] getPlayerOneBattleship() {//4
        return oneBattleship;
    }
    public int[][] getPlayerOneCruiser() {//3
        return oneCruiser;
    }
    public int[][] getPlayerOneSubmarine(){//3
        return oneSubmarine;
   }
    public int[][] getPlayerOneDestroyer() {//2
        return oneDestroyer;
    }
    //p2
    public void setPlayerTwoCarrier(int[][] coords) {//5
        twoCarrier = coords;
    }
    public void setPlayerTwoBattleship(int[][] coords){//4
        twoBattleship = coords;
   }
    public void setPlayerTwoCruiser(int[][] coords) {//3
        twoCruiser = coords;
    }
    public void setPlayerTwoSubmarine(int[][] coords) {//3
        twoSubmarine = coords;
    }
    public void setPlayerTwoDestroyer(int[][] coords) {//2
        twoDestroyer = coords;
    }

    public int[][] getPlayerTwoCarrier() {//5
        return twoCarrier;
    }
    public int[][] getPlayerTwoBattleship() {//4
        return twoBattleship;
    }
    public int[][] getPlayerTwoCruiser(){//3
        return twoCruiser;
    }
    public int[][] getPlayerTwoSubmarine() {//3
        return twoSubmarine;
    }
    public int[][] getPlayerTwoDestroyer() {//2
        return twoDestroyer;
    }
    public boolean matchCoordsOne(int down, int across){//
        boolean carrier = false;
        boolean battleship = false;
        boolean cruiser = false;
        boolean submarine = false;
        boolean destroyer = false;
        TwoPlayerBoards access = new TwoPlayerBoards();

      //each ship at this val will check. these sare all arrays o' 64, so if its blank they wont respond
        if (twoCarrier[down][across] ==access.getGameBoardVal(down, across)){
            carrier = true;
        }
        if (twoBattleship[down][across] ==access.getGameBoardVal(down, across)){
            carrier = true;
        } if (twoCruiser[down][across] ==access.getGameBoardVal(down, across)){
            carrier = true;
        } if (twoSubmarine[down][across] ==access.getGameBoardVal(down, across)){
            carrier = true;
        } if (twoDestroyer[down][across] ==access.getGameBoardVal(down, across)){
            carrier = true;
        }
        ///////////
        if (carrier){
            return carrier;
        }
        if (battleship) {
              return battleship;
        }
        if (cruiser) {
            return cruiser;
        }
        if (submarine) {
            return submarine;
        }
        if (destroyer){
            return destroyer;
}
    }
}