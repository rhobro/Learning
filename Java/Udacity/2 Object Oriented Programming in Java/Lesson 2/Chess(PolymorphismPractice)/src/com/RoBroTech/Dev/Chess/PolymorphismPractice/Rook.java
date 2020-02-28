/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Chess(PolymorphismPractice)
 * File Name: Rook.java
 * Last Modified: 09/04/19 19:53
 */

package com.RoBroTech.Dev.Chess.PolymorphismPractice;

class Rook extends Piece{
    boolean isValidMove(Position newPosition){
        if(newPosition.column == this.position.column || newPosition.row == this.position.row){
            return true;
        }
        else{
            return false;
        }
    }
}
