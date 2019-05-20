package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;


public class GUIBuilder {
    private Stage primaryStage;
    private ArrayList<TextField> expressions;
    private ArrayList<TextField> results;
    private static final int INDENT = 5;
    private static final int RESULT_WIDTH = 120;
    private static final int THREADS_MAX_COUNT = 8;
    private static final int WINDOW_HEIGHT = 28 * THREADS_MAX_COUNT + 60;

    GUIBuilder(Stage primaryStage) {
        this.primaryStage = primaryStage;
         expressions = new ArrayList<>();
         results = new ArrayList<>();
    }

    public void buildGUI() {

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button calcButton = new Button("Calculate");

        HBox menuHBox = new HBox(addButton, deleteButton, calcButton);
        menuHBox.setSpacing(INDENT);
        menuHBox.setPadding(new Insets(INDENT));

        addButton.setMaxWidth(Double.MAX_VALUE);
        deleteButton.setMaxWidth(Double.MAX_VALUE);
        calcButton.setMaxWidth(Double.MAX_VALUE);
        menuHBox.setHgrow(addButton, Priority.ALWAYS);
        menuHBox.setHgrow(deleteButton, Priority.ALWAYS);
        menuHBox.setHgrow(calcButton, Priority.ALWAYS);


        Label label1 = new Label("Expression:");
        Label label2 = new Label("Result:");

        HBox titleHBox = new HBox(label1, label2);
        titleHBox.setPadding(new Insets(INDENT));
        titleHBox.setSpacing(INDENT);

        label1.setMaxWidth(Double.MAX_VALUE);
        label2.setMaxWidth(RESULT_WIDTH);
        titleHBox.setHgrow(label1, Priority.ALWAYS);
        titleHBox.setHgrow(label2, Priority.ALWAYS);


        VBox exprVBox = new VBox();
        VBox resVBox = new VBox();

        HBox txtfldHBox = new HBox(exprVBox, resVBox);
        txtfldHBox.setSpacing(INDENT);
        txtfldHBox.setPadding(new Insets(INDENT));

        exprVBox.setSpacing(3);
        resVBox.setSpacing(3);
        exprVBox.setMaxWidth(Double.MAX_VALUE);
        resVBox.setMaxWidth(RESULT_WIDTH);
        txtfldHBox.setHgrow(exprVBox, Priority.ALWAYS);
        txtfldHBox.setHgrow(resVBox, Priority.ALWAYS);


        VBox root = new VBox(menuHBox, titleHBox, txtfldHBox);
        Scene scene = new Scene(root, 400, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (exprVBox.getChildren().size() < THREADS_MAX_COUNT) {
                    TextField exprField = new TextField();
                    exprVBox.getChildren().add(exprField);
                    TextField resField = new TextField();
                    resField.setEditable(false);
                    resVBox.getChildren().add(resField);

                    expressions.add(exprField);
                    results.add(resField);
                }
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (exprVBox.getChildren().size() > 0) {
                    expressions.remove(exprVBox.getChildren().size()-1);
                    results.remove(resVBox.getChildren().size()-1);

                    exprVBox.getChildren().remove(exprVBox.getChildren().size() - 1);
                    resVBox.getChildren().remove(resVBox.getChildren().size() - 1);
                }
            }
        });
        
        calcButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i< expressions.size();i++) {
                    new Thread(new Calculator(expressions.get(i),results.get(i))).start();
                }
            }
        });

    }

    public void display() {
        primaryStage.show();
    }
}
