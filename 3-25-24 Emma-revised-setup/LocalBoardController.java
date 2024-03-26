package edu.sdccd.cisc191.template;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
public class LocalBoardController {
    private LocalPlayerBoards access;
    private int currentRow;
    private int currentCol;
    private Button currentButton;
    private Battleships shipAccess;
    private int playerTurn;

    public LocalBoardController() {
        access = new LocalPlayerBoards();
        shipAccess = new Battleships();
        currentRow = 0;
        currentCol = 0;
        currentButton = new Button();
        playerTurn = 1;//reminder to change playerTurn after every turn!
    }

    //updates last pressed button, and its coords.
    //used for both atk and def. def will go first, then be disabled. atk will go next.
    public void currentButton(int col, int row, Button button) {
        currentRow = row;
        currentCol = col;
        currentButton = button;
    }

    //ATK's check if attack is  hit or miss. works for both players.
    //fixed that. note: battleship storage is only for int[]
    public boolean hitMissTest() {

        boolean foundMatch = false;
        if (playerTurn == 1) {
            int[] carrier = shipAccess.getPlayerTwoCarrier();
            for (int i = 0; i < carrier.length; i++) {
                if ((currentCol == carrier[i + 1]) && (currentRow == carrier[i])) {
                    foundMatch = true;
                }
            }
            int[] battleship = shipAccess.getPlayerTwoBattleship();
            for (int i = 0; i < battleship.length; i++) {
                if ((currentCol == battleship[i + 1]) && (currentRow == battleship[i])) {
                    foundMatch = true;
                }
            }
            int[] cruiser = shipAccess.getPlayerTwoCruiser();
            for (int i = 0; i < cruiser.length; i++) {
                if ((currentCol == cruiser[i + 1]) && (currentRow == cruiser[i])) {
                    foundMatch = true;
                }
            }
            int[] submarine = shipAccess.getPlayerTwoSubmarine();
            for (int i = 0; i < submarine.length; i++) {
                if ((currentCol == submarine[i + 1]) && (currentRow == submarine[i])) {
                    foundMatch = true;
                }
            }
            int[] destroyer = shipAccess.getPlayerTwoDestroyer();
            for (int i = 0; i < destroyer.length; i++) {
                if ((currentCol == destroyer[i + 1]) && (currentRow == destroyer[i])) {
                    foundMatch = true;
                }
            }
        } else {//p2
            int[] carrierTwo = shipAccess.getPlayerOneCarrier();
            for (int i = 0; i < carrierTwo.length; i++) {
                if ((currentCol == carrierTwo[i + 1]) && (currentRow == carrierTwo[i])) {
                    foundMatch = true;
                }
            }
            int[] battleshipTwo = shipAccess.getPlayerOneBattleship();
            for (int i = 0; i < battleshipTwo.length; i++) {
                if ((currentCol == battleshipTwo[i + 1]) && (currentRow == battleshipTwo[i])) {
                    foundMatch = true;
                }
            }
            int[] cruiserTwo = shipAccess.getPlayerOneCruiser();
            for (int i = 0; i < cruiserTwo.length; i++) {
                if ((currentCol == cruiserTwo[i + 1]) && (currentRow == cruiserTwo[i])) {
                    foundMatch = true;
                }
            }
            int[] submarineTwo = shipAccess.getPlayerOneSubmarine();
            for (int i = 0; i < submarineTwo.length; i++) {
                if ((currentCol == submarineTwo[i + 1]) && (currentRow == submarineTwo[i])) {
                    foundMatch = true;
                }
            }
            int[] destroyerTwo = shipAccess.getPlayerOneDestroyer();
            for (int i = 0; i < destroyerTwo.length; i++) {
                if ((currentCol == destroyerTwo[i + 1]) && (currentRow == destroyerTwo[i])) {
                    foundMatch = true;
                }
            }
        }
        currentButton.setDisable(true);
        return foundMatch;
    }

    public void ATKboardEnable(boolean enable) {
        GridPane temp = new GridPane();
        temp = access.getAtkBoard();
        if (enable) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    seekerGridpane(temp, col, row).setDisable(false);
                }
            }
        } else {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    seekerGridpane(temp, col, row).setDisable(true);
                }
            }
        }
    }

    public void DEFboardEnable(boolean enable) {
        GridPane temp = new GridPane();
        temp = access.getDefBoard();
        if (enable) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    seekerGridpane(temp, col, row).setDisable(false);
                }
            }
        } else {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    seekerGridpane(temp, col, row).setDisable(true);
                }
            }
        }
    }

    public void shipSetup(int playerNumber) {
        access.getOrientation();
        carrierSetup(playerNumber);
        battleshipSetup(playerNumber);
        submarineSetup(playerNumber);
        cruiserSetup(playerNumber);
        destroyerSetup(playerNumber);
    }

    public void carrierSetup(int playerNumber) {
        DEFboardEnable(true);//enables ENTIRE board. even if the shipplacementcheck gets clicked, should reset it.
        if (access.getOrientation()) {//horizontal
            access.setInstructions("Click a tile to place CARRIER(horizontal)");
            if (currentRow + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] carrierArray = new int[10];
            carrierArray[0] = currentCol;
            carrierArray[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                carrierArray[i + 2] = currentCol;
                carrierArray[i + 3] = currentRow + i + 1;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneCarrier(carrierArray);
            } else {
                shipAccess.setPlayerTwoCarrier(carrierArray);
            }
        } else {//vertical
            access.setInstructions("Click a tile to place CARRIER(vertical)");
            if (currentCol + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] carrierArray = new int[10];
            carrierArray[0] = currentCol;
            carrierArray[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                carrierArray[i + 2] = currentCol + i + 1;
                carrierArray[i + 3] = currentRow;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneCarrier(carrierArray);
            } else {
                shipAccess.setPlayerTwoCarrier(carrierArray);
            }
        }
    }

    public void battleshipSetup(int playerNumber) {
        DEFboardEnable(true);//enables ENTIRE board. even if the shipplacementcheck gets clicked, should reset it.
        if (access.getOrientation()) {//horizontal
            access.setInstructions("Click a tile to place CARRIER(horizontal)");
            if (currentRow + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] battleArray = new int[10];
            battleArray[0] = currentCol;
            battleArray[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                battleArray[i + 2] = currentCol;
                battleArray[i + 3] = currentRow + i + 1;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneBattleship(battleArray);
            } else {
                shipAccess.setPlayerTwoBattleship(battleArray);
            }
        } else {//vertical
            access.setInstructions("Click a tile to place CARRIER(vertical)");
            if (currentCol + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] battleArray = new int[10];
            battleArray[0] = currentCol;
            battleArray[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                battleArray[i + 2] = currentCol + i + 1;
                battleArray[i + 3] = currentRow;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneBattleship(battleArray);
            } else {
                shipAccess.setPlayerTwoBattleship(battleArray);
            }
        }
    }
    public void cruiserSetup(int playerNumber){
        DEFboardEnable(true);//enables ENTIRE board. even if the shipplacementcheck gets clicked, should reset it.
        if (access.getOrientation()) {//horizontal
            access.setInstructions("Click a tile to place CARRIER(horizontal)");
            if (currentRow + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] array = new int[10];
            array[0] = currentCol;
            array[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                array[i + 2] = currentCol;
                array[i + 3] = currentRow + i + 1;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneCruiser(array);
            } else {
                shipAccess.setPlayerTwoCruiser(array);
            }
        } else {//vertical
            access.setInstructions("Click a tile to place CARRIER(vertical)");
            if (currentCol + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] array = new int[10];
            array[0] = currentCol;
            array[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                array[i + 2] = currentCol + i + 1;
                array[i + 3] = currentRow;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneCruiser(array);
            } else {
                shipAccess.setPlayerTwoCruiser(array);
            }
        }
    }
    public void submarineSetup(int playerNumber){
        DEFboardEnable(true);//enables ENTIRE board. even if the shipplacementcheck gets clicked, should reset it.
        if (access.getOrientation()) {//horizontal
            access.setInstructions("Click a tile to place CARRIER(horizontal)");
            if (currentRow + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] array = new int[10];
            array[0] = currentCol;
            array[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                array[i + 2] = currentCol;
                array[i + 3] = currentRow + i + 1;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneSubmarine(array);
            } else {
                shipAccess.setPlayerTwoSubmarine(array);
            }
        } else {//vertical
            access.setInstructions("Click a tile to place CARRIER(vertical)");
            if (currentCol + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] array = new int[10];
            array[0] = currentCol;
            array[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                array[i + 2] = currentCol + i + 1;
                array[i + 3] = currentRow;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneSubmarine(array);
            } else {
                shipAccess.setPlayerTwoSubmarine(array);
            }
        }
    }
    public void destroyerSetup(int playerNumber){
        DEFboardEnable(true);//enables ENTIRE board. even if the shipplacementcheck gets clicked, should reset it.
        if (access.getOrientation()) {//horizontal
            access.setInstructions("Click a tile to place CARRIER(horizontal)");
            if (currentRow + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] array = new int[10];
            array[0] = currentCol;
            array[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                array[i + 2] = currentCol;
                array[i + 3] = currentRow + i + 1;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneDestroyer(array);
            } else {
                shipAccess.setPlayerTwoDestroyer(array);
            }
        } else {//vertical
            access.setInstructions("Click a tile to place CARRIER(vertical)");
            if (currentCol + 4 > 8) {//stops from weird ship placement
                carrierSetup(playerTurn);//forces them to go back to beginning.
            }
            int[] array = new int[10];
            array[0] = currentCol;
            array[1] = currentRow;
            GridPane boardref = access.getDefBoard();
            for (int i = 0; i < 7; i++) {//placing the four other tiles for the ship automatically.
                //BECOME BLUE
                seekerGridpane(boardref, currentCol, currentRow + i).setStyle("-fx-background-color: rgb(0, 0, 255)");
                array[i + 2] = currentCol + i + 1;
                array[i + 3] = currentRow;
            }
            if (playerTurn == 1) {
                shipAccess.setPlayerOneDestroyer(array);
            } else {
                shipAccess.setPlayerTwoDestroyer(array);
            }
        }
    }

    //literally just for one thing and yes i need this.
    //stupid gridpane and its lack of seeker methods.
    //need to check on th
    private Button seekerGridpane(GridPane gridPane, int column, int row) {
        Button button = new Button();
        for (int i = 0; i < gridPane.getChildren().size(); i++) {
            if ((GridPane.getColumnIndex(gridPane.getChildren().get(i)) == column) &&
                    (GridPane.getRowIndex(gridPane.getChildren().get(i)) == row) &&
                    (gridPane.getChildren().get(i) instanceof Button)) {
                button = (Button) gridPane.getChildren().get(i);
            }
        }
        return button;
    }
    public int getPlayerTurn(){
        return playerTurn;
    }
    public void setPlayerTurn ( int turn){
        playerTurn = turn;
    }
}

