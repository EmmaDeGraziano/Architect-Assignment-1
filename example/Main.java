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

public class Main extends Application {
    public static void main(String[] args) {

       Main.launch(args);
        //a window and windowframe.
        Menu access = new Menu();
        access.sceneMenu();
        //entering menu
    }

    public void start(Stage primaryStage) {
        primaryStage.setWidth(300.0);
        primaryStage.setHeight(300.0);


    }
}