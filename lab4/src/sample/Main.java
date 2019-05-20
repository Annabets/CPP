package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.concurrent.Exchanger;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        //System.out.printf("%s started... \n", Thread.currentThread().getName());
        GUIBuilder guiBuilder = new GUIBuilder(primaryStage);
        guiBuilder.buildGUI();
        guiBuilder.display();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
