/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: JavaFXDemo
 * File Name: AlertBox.java
 * Last Modified: 17/07/19 13:24
 */

package com.RoBroTech.Dev.JavaFXDemo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String alertTitle, String alertMessage) {
        Stage alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle(alertTitle);
        alertStage.setMinWidth(250);
        Label label = new Label(alertMessage);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> alertStage.close());

        VBox layout = new VBox();
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        alertStage.setScene(scene);
        alertStage.showAndWait();
    }
}
