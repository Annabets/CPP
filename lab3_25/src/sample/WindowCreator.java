package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WindowCreator {
    private Stage primaryStage;

    WindowCreator(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void createWindow(Store store) {

        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 115);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        for (int i = 0; i < 2; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / 3.0);
            gridpane.getColumnConstraints().add(column);
        }
        Label productName = new Label("Bread");
        gridpane.add(productName, 0, 0);
        Label price = new Label("10.00");
        gridpane.add(price, 1, 0);
        Button addToTruckButton = new Button("Add to truck");
        gridpane.add(addToTruckButton, 2, 0);

        Label customerMoney = new Label("Customer: " + store.getCustomer().getMoney());
        gridpane.add(customerMoney, 0, 3);
        Label productsPrice = new Label("Truck: " + store.getCustomer().getTruck().getPrice());
        gridpane.add(productsPrice, 1, 3);

        addToTruckButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                store.getCustomer().takeProduct(new Bread());
                store.getCustomer().putProductToTruck();
                productsPrice.setText("Truck: " + store.getCustomer().getTruck().getPrice());
            }
        });


        productName = new Label("Matches");
        gridpane.add(productName, 0, 1);
        price = new Label("1.5");
        gridpane.add(price, 1, 1);
        addToTruckButton = new Button("Add to truck");
        gridpane.add(addToTruckButton, 2, 1);

        addToTruckButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                store.getCustomer().takeProduct(new Matches());
                store.getCustomer().putProductToTruck();
                productsPrice.setText("Truck: " + store.getCustomer().getTruck().getPrice());
            }
        });


        productName = new Label("Milk");
        gridpane.add(productName, 0, 2);
        price = new Label("9.5");
        gridpane.add(price, 1, 2);
        addToTruckButton = new Button("Add to truck");
        gridpane.add(addToTruckButton, 2, 2);

        addToTruckButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                store.getCustomer().takeProduct(new Milk());
                store.getCustomer().putProductToTruck();
                productsPrice.setText("Truck: " + store.getCustomer().getTruck().getPrice());
            }
        });


        Label packLabel = new Label("Package:");

        ObservableList<String> prod = FXCollections.observableArrayList();
        ListView<String> prodListView = new ListView<String>(prod);
        prodListView.setPrefHeight(100);

        FlowPane flowPane = new FlowPane(Orientation.VERTICAL, 10, 10, packLabel, prodListView);
        flowPane.setPadding(new Insets(10));



        Button buyProducts = new Button("Buy products");
        gridpane.add(buyProducts, 2, 3);

        buyProducts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                store.askForMoney();
                for (Product i : store.getCustomer().getPack().getProducts()) {
                    prod.add(i.getClass().getSimpleName());
                }
                productsPrice.setText("Truck: " + store.getCustomer().getTruck().getPrice());
                customerMoney.setText("Customer: " + store.getCustomer().getMoney());
            }
        });


        root.setCenter(gridpane);
        root.setRight(flowPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(store.getStoreName());
    }

    public void display() {

        primaryStage.show();
    }
}
