/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: FootyScore
 * File Name: MainActivity.java
 * Last Modified: 15/05/19 20:21
 */

package com.RoBroTech.Dev.FootyScore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member fields
    // Number of points for Team A
    private static int scoreTeamA = 0;
    // Number of points for Team B
    private static int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setting Team A score to 0
        this.displayForTeamA(scoreTeamA);
        // Setting Team B score to 0
        this.displayForTeamA(scoreTeamB);
    }

    // Methods to update Team A points
    // Method for when the +3 button is clicked
    public void teamA_Goal(View view) {
        this.displayForTeamA(1);
    }

    // Methods to update Team B points
    // Method for when the +3 button is clicked
    public void teamB_Goal(View view) {
        this.displayForTeamB(1);
    }

    // Reset method to set scores back to 0
    public void resetScores(View view) {
        this.displayForTeamA(0);
        this.displayForTeamB(0);
    }

    // Displays the given score for Team A.
    public void displayForTeamA(int score) {
        if(score != 0) {
            scoreTeamA += score;
        } else {
            scoreTeamA = 0;
        }
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    // Displays the given score for Team B.
    public void displayForTeamB(int score) {
        if(score != 0) {
            scoreTeamB += score;
        } else {
            scoreTeamB = 0;
        }
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }
}
