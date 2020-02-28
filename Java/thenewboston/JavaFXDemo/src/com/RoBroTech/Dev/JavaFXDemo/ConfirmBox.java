/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: JavaFXDemo
 * File Name: ConfirmBox.java
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

public class ConfirmBox {

    private static boolean answer;

    public static boolean display(String confirmTitle, String confirmMessage) {
        Stage alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);
        alertStage.setTitle(confirmTitle);
        alertStage.setMinWidth(250);
        Label label = new Label(confirmMessage);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(event -> {
            answer = true;
            alertStage.close();
        });
        noButton.setOnAction(event -> {
            answer = false;
            alertStage.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        alertStage.setScene(scene);
        alertStage.showAndWait();

        return answer;
    }
}
