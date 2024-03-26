package edu.sdccd.cisc191.template;
import javafx.scene.control.Button;

public class Battleships {
    private int[] oneCarrier;
    private int[] twoCarrier;
    private int[] oneBattleship;
    private int[] twoBattleship;
    private int[] oneCruiser;
    private int[] twoCruiser;
    private int[] oneSubmarine;
    private int[] twoSubmarine;
    private int[] oneDestroyer;
    private int[] twoDestroyer;

    public Battleships() {
    }

    //p1
    public void setPlayerOneCarrier(int[] coords) {//5
        oneCarrier = coords;
    }

    public void setPlayerOneBattleship(int[] coords) {//4
        oneBattleship = coords;
    }

    public void setPlayerOneCruiser(int[] coords) {//3
        oneCruiser = coords;
    }

    public void setPlayerOneSubmarine(int[] coords) {//3
        oneSubmarine = coords;
    }

    public void setPlayerOneDestroyer(int[] coords) {//2
        oneDestroyer = coords;
    }

    public int[] getPlayerOneCarrier() {//5
        return oneCarrier;
    }

    public int[] getPlayerOneBattleship() {//4
        return oneBattleship;
    }

    public int[] getPlayerOneCruiser() {//3
        return oneCruiser;
    }

    public int[] getPlayerOneSubmarine() {//3
        return oneSubmarine;
    }

    public int[] getPlayerOneDestroyer() {//2
        return oneDestroyer;
    }

    //p2
    public void setPlayerTwoCarrier(int[] coords) {//5
        twoCarrier = coords;
    }

    public void setPlayerTwoBattleship(int[] coords) {//4
        twoBattleship = coords;
    }

    public void setPlayerTwoCruiser(int[] coords) {//3
        twoCruiser = coords;
    }

    public void setPlayerTwoSubmarine(int[] coords) {//3
        twoSubmarine = coords;
    }

    public void setPlayerTwoDestroyer(int[] coords) {//2
        twoDestroyer = coords;
    }

    public int[] getPlayerTwoCarrier() {//5
        return twoCarrier;
    }

    public int[] getPlayerTwoBattleship() {//4
        return twoBattleship;
    }

    public int[] getPlayerTwoCruiser() {//3
        return twoCruiser;
    }

    public int[] getPlayerTwoSubmarine() {//3
        return twoSubmarine;
    }

    public int[] getPlayerTwoDestroyer() {//2
        return twoDestroyer;
    }
}