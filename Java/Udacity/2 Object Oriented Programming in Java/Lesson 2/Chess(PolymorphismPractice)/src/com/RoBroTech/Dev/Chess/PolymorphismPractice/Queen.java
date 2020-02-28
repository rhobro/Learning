/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Chess(PolymorphismPractice)
 * File Name: Queen.java
 * Last Modified: 09/04/19 20:02
 */

package com.RoBroTech.Dev.Chess.PolymorphismPractice;

public class Queen extends Piece {
    boolean isValidMove(Position newPosition) {
        if(super.isValidMove(newPosition)) {
            if((newPosition.column == this.position.column || newPosition.row == this.position.row)
                    && (Math.abs(newPosition.column - this.position.column) == Math.abs(newPosition.row - this.position.row))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
