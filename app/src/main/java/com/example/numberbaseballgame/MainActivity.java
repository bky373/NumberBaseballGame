package com.example.numberbaseballgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numberbaseballgame.R;

import java.nio.charset.MalformedInputException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] comNumbers = new int[3];
    int inputTextCount = 0;

    TextView[] inputTextView = new TextView[3];
    Button[] numButton = new Button[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comNumbers = getComNumbers();

        for (int i = 0; i < inputTextView.length; i++) {
            inputTextView[i] = findViewById(R.id.input_text_view_0 + i);
        }

        for (int i = 0; i < numButton.length; i++) {
            numButton[i] = findViewById(R.id.num_button_0 + i);
        }

        for(Button getNumButton : numButton)
            getNumButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (inputTextCount < 3) {
                        Button button = findViewById(v.getId());
                        inputTextView[inputTextCount].setText(button.getText().toString());
                        button.setEnabled(false);
                        inputTextCount++;
                    } else {
                        Toast.makeText(getApplicationContext(), "히트 버튼을 눌러주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
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
