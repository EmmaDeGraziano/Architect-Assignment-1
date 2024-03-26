package edu.sdccd.cisc191.template;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
public class LocalPlayerBoards {
    private Button orientation;
    private GridPane ATKboard;
    private GridPane DEFboard;
    private Label header;
    private Label instructions;
    private LocalBoardController access;
    /////////////////////////////////////
//ONLY HANDLES SETUP OF BOARD
    //BOARD FUNCTIONS-like handling setup- GO IN BOARDCONTROLLER
    //BOARD DATA-ship coords- ARE IN BATTLESHIPS
    //note: i have left orientation's setOnAction in constructor. Change?
    /////////////////////////////////////

    public LocalPlayerBoards() {
        access = new LocalBoardController();
        ATKboard = new GridPane();
        DEFboard = new GridPane();
        header = new Label("Player One's Battleship Boards");
        instructions = new Label("Your ships will go on the right board.\n Tip: check your hands to find right!");
     //button.
        orientation = new Button("Orientation: Click to Change");
        orientation.setOnAction(evt -> {
            //hori/verti stuff..
            if (orientation.getText().equals("Horizontal")){
                orientation = new Button("Vertical");
            }
            else{
                orientation = new Button("Horizontal");
            }
        });
    }
    public void localSceneSetup(){
        LocalBoardController access = new LocalBoardController();
        BorderPane root = new BorderPane();
        Scene localPlayer = new Scene(root, 600, 600);
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        ATKboard = atkboardSetup();
        access.ATKboardEnable(false);//disabled buttons(till setups over.)
        DEFboard = defboardSetup();
        access.DEFboardEnable(true);//enabled buttons(for now.)
        hbox.getChildren().addAll(ATKboard, DEFboard);
        vbox.getChildren().addAll(header, instructions, orientation, hbox);
        root.getChildren().add(vbox);
    }
    //setters and getters
    public void setHeader(String str){
        header = new Label(str);
    }
    public Label getHeader(){
        return header;
    }
    public void setInstructions(String str){
        instructions = new Label(str);
    }
    public Label getInstructions(){
        return instructions;
    }
    public void setAtkBoard(GridPane gridpane){
        ATKboard = gridpane;
    }
    public GridPane getAtkBoard(){
        return ATKboard;
    }
    public GridPane getDefBoard(){
        return DEFboard;
    }
    public void setDefBoard(GridPane gridpane){
        DEFboard = gridpane;
    }
    //horizontal/"orientation" is TRUE
    //vertical is FALSE.
    public boolean getOrientation(){
        boolean sentinel = false;
       if (orientation.getText().equals("Horizontal")){
                sentinel= true;
            }
        return sentinel;
    }
    public GridPane atkboardSetup(){
        GridPane gridpane = new GridPane();
        for (int col = 0; col<8;col++){
            for (int row = 0; row<8;row++){
                Button button = new Button();
                button.setOnAction(evt -> {
                    access.currentButton(gridpane.getColumnIndex(button), gridpane.getRowIndex(button), button);
                    if (access.hitMissTest()){
                        button.setStyle("-fx-background-color: rgb(255, 0, 0);");
                    }
                        else{
                                button.setStyle("-fx-background-color: rgb(255, 255, 255);");
                    }
                });
                gridpane.add(button, col, row);
            }
        }
        return gridpane;
    }
    public GridPane defboardSetup(){
        GridPane gridpane = new GridPane();
        for (int col = 0; col<8;col++){
            for (int row = 0; row<8;row++){
                Button button = new Button();
                button.setOnAction(evt -> {
                    access.currentButton(gridpane.getColumnIndex(button), gridpane.getRowIndex(button), button);
                });
                gridpane.add(button, col, row);
            }
        }
        return gridpane;
    }
}
