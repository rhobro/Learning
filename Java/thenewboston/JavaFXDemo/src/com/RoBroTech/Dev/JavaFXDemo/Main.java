/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: JavaFXDemo
 * File Name: Main.java
 * Last Modified: 12/08/19 21:32
 */

package com.RoBroTech.Dev.JavaFXDemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {

    // Member fields
    // Scenes
    Scene scene;
    Stage window;
    TreeView<String> treeView;
    TextField nameInput, priceInput, quantityInput;

    TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception {
        SupaDupaEventHandler handler = new SupaDupaEventHandler();
        this.window = primaryStage;
        this.window.setMinWidth(250);
        this.window.setMinHeight(250);
        this.window.setTitle("Checkbox Example");
        this.window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();
        secondLabel.textProperty().bind(userInput.textProperty());

        HBox bottomText = new HBox();
        bottomText.getChildren().addAll(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(userInput, bottomText);
        this.scene = new Scene(layout);
        this.window.setScene(this.scene);
        this.window.show();
    }

    private ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 1005.10, 49));
        products.add(new Product("Cat", 400.00, 2));
        products.add(new Product("Car", 999999.99, 1));
        products.add(new Product("TV", 4500.00, 20));
        products.add(new Product("Bouncy Ball", 15.10, 459));
        products.add(new Product("Toilet", 100.00, 75));
        products.add(new Product("Corn", 1.10, 25));

        return products;
    }

    private TreeItem<String> makeBranch(String itemToAdd, @NotNull TreeItem<String> placeToAddItem) {
        TreeItem<String> item = new TreeItem<>(itemToAdd);
        item.setExpanded(true);
        placeToAddItem.getChildren().add(item);
        return item;
    }

    private void addButtonClicked() {
        Product product = new Product(this.nameInput.getText(), Double.parseDouble(this.priceInput.getText()), Integer.parseInt(this.quantityInput.getText()));
        this.table.getItems().add(product);
        this.nameInput.clear();
        this.priceInput.clear();
        this.quantityInput.clear();
    }

    private void deleteButtonClicked() {
        ObservableList<Product> selectedItems, allItems;
        selectedItems = this.table.getSelectionModel().getSelectedItems();
        allItems = this.table.getItems();

        selectedItems.forEach(allItems::remove);
    }

    private void closeProgram() {
        boolean close = ConfirmBox.display("Close Program?", "Are you sure you want to close the program?");
        if (close) {
            window.close();
        }
    }
}
