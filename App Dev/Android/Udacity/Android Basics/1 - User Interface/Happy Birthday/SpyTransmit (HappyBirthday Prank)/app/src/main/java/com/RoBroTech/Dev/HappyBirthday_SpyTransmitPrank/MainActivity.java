/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: SpyTransmit (HappyBirthday Prank)
 * File Name: MainActivity.java
 * Last Modified: 18/05/19 09:36
 */

package com.RoBroTech.Dev.HappyBirthday_SpyTransmitPrank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // Member fields
    // The progress bar shown in fake_upload.xml
    private ProgressBar fakeUpload;
    // The TextView displaying the ProgressBar's percentage
    private TextView fakeUploadPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(LocalDate.now().equals(LocalDate.of(2019, 5, 13))) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.fake_upload);
            this.fakeUpload = findViewById(R.id.progressBar);
            this.fakeUploadPercentage = findViewById(R.id.percentage_number);
        }
    }

    // Method called when the start button is clicked
//    public void start(View view) {
//        if(java.time.LocalDate.now().equals(java.time.LocalDate.of(2019, 5, 13))) {
//            setContentView(R.layout.activity_main);
//        } else {
//            Button startButton = findViewById(R.id.startButton);
//            startButton.setVisibility(View.INVISIBLE);
//            progressBarUpdate(1, 1);
//        }
//    }

    // Method to change the value shown by the progress bar in fake_upload.xml
    public void progressBarUpdate(int value, int incrementTiming) {
        for(int i = 0; i < 100; i += value) {
            this.fakeUpload.setProgress(i, true);
            this.fakeUploadPercentage.setText(i);
//            TimeUnit.SECONDS.sleep(incrementTiming);
        }
    }
}
