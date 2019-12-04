package com.example.numberbaseballgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.numberbaseballgame.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] comNumbers = new int[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comNumbers = getComNumbers();
    }

    public int[] getComNumbers(){
        int[] setComNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            setComNumbers[i] = new Random().nextInt(10);
            for (int j = 0; j < i; j++) {
                if(setComNumbers[i] == setComNumbers[j]){
                    i--;
                    break;
                }
            }
        }

        Log.e("setComNumbers","setComNumbers= " + setComNumbers[0] + " " + setComNumbers[1] + " " + setComNumbers[2]);
        return setComNumbers;
    }
}
