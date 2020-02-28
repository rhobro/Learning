/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Chess(PolymorphismPractice)
 * File Name: Bishop.java
 * Last Modified: 09/04/19 19:51
 */

package com.RoBroTech.Dev.Chess.PolymorphismPractice;

class Bishop extends Piece{
    boolean isValidMove(Position newPosition){
        if(Math.abs(newPosition.column - this.position.column) == Math.abs(newPosition.row - this.position.row)){
            return true;
        }
        else{
            return false;
        }
    }
}
