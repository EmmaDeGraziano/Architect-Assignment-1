package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.application.Application;

/******************************
 * All this class does(so far) is start the program and send us over to menu.
*********************/
public class Main extends Application {
    public static void main(String[] args) {
        TwoPlayerBoards access = new TwoPlayerBoards();
        Main.launch(args);
        //menu will call twoplayer start stuff when button pressed.(setOnAction)
        access.boardSetupP1();//should set up player stuff.
        access.boardSetupP2();


    }
//will mess with stage width/length when program runs
    /** THE SETUP FOR STAGE+ TRANSFER TO MENU**/
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setWidth(300.0);
        primaryStage.setHeight(300.0);
        Menu access = new Menu(primaryStage);
        access.sceneMenu();
        //entering menu

    }
}
