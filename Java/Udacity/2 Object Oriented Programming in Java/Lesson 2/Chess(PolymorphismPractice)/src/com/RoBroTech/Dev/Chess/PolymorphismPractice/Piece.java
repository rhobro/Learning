/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Chess(PolymorphismPractice)
 * File Name: Piece.java
 * Last Modified: 09/04/19 19:54
 */

package com.RoBroTech.Dev.Chess.PolymorphismPractice;

public class Piece {
    Position position;

    boolean isValidMove(Position newPosition){
        if(newPosition.row>0 && newPosition.column>0 && newPosition.row<8 && newPosition.column<8){
            return true;
        }
        else{
            return false;
        }
    }
}
