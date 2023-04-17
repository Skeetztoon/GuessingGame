package com.example.guessinggame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.guessinggame.databinding.ActivityMainBinding;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private TextView tryText;

    private Button guessButton;

    private EditText enteringWindow;

    private Button restartButton;

    private TextView counter;

    private final Random random = new Random();

    private int randNum;

    private int cntr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randNum = random.nextInt(100);
        System.out.println(randNum);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        counter = findViewById(R.id.counter);
        tryText = findViewById(R.id.tryText);
        guessButton = findViewById(R.id.guessButton);
        enteringWindow = findViewById(R.id.enteringWindow);
        restartButton = findViewById(R.id.restartButton);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cntr++;
                counter.setText("Counter: " + cntr);
                restartButton.setVisibility(View.GONE);
                System.out.println(Integer.parseInt(enteringWindow.getText().toString()));
                if (Integer.parseInt(enteringWindow.getText().toString()) == randNum) {
                    tryText.setText(R.string.correct);
                    restartButton.setVisibility(View.VISIBLE);
                } else if (Integer.parseInt(enteringWindow.getText().toString()) > randNum) {
                    tryText.setText(R.string.less);
                } else if (Integer.parseInt(enteringWindow.getText().toString()) > randNum) {
                    tryText.setText(R.string.more);
                }
            }});
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cntr = 0;
                counter.setText("Counter: " + cntr);
                randNum = random.nextInt(100);
                System.out.println(randNum);
                restartButton.setVisibility(View.GONE);
            }
        });

        };
    }