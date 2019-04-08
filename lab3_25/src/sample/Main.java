package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        WindowCreator windowCreator = new WindowCreator(primaryStage);
        windowCreator.createWindow(new Store("Bread, Matches and Milk",new Customer(new Truck(),100.00)));
        windowCreator.display();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
