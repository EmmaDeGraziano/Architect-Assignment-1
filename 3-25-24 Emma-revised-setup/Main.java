package edu.sdccd.cisc191.template;

public class Main {
}
package edu.sdccd.cisc191.template;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application{

    private final MenuController menuController = new MenuController();
    private final Scene scene = new Scene( menuController.setupRoot(), 600, 600 );

    public static void main(String[] args) { launch(); }

    public void start(Stage stage) {
        stage.setTitle("Battleship 2.0!");
        stage.setScene(scene);
        stage.show();
    }



}