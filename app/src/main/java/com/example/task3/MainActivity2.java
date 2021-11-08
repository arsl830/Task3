package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private TextView noq, questions;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<Quiz> quizArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        noq = findViewById(R.id.noq);
        questions = findViewById(R.id.questions);
        option1Btn = findViewById(R.id.button1);
        option2Btn = findViewById(R.id.button2);
        option3Btn = findViewById(R.id.button3);
        option4Btn = findViewById(R.id.button4);
        quizArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizArrayList);
        currentPos = random.nextInt(quizArrayList.size());
        setQuizQuestion(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
    }

    private void getQuizQuestion(ArrayList<Quiz> quizArrayList) {
        quizArrayList.add(new Quiz("aaaaa", "a","b", "c", "d","a"));
        quizArrayList.add(new Quiz("bbbbb", "a","b", "c", "d","a"));
        quizArrayList.add(new Quiz("ccccc", "a","b", "c", "d","a"));
        quizArrayList.add(new Quiz("ddddd", "a","b", "c", "d","a"));
    }
    private void setQuizQuestion(int currentPos){
        noq.setText("Questions attempted: "+ questionAttempted+ "/10");
        questions.setText(quizArrayList.get(currentPos).getQuestion());
        option1Btn.setText(quizArrayList.get(currentPos).getButton1());
        option2Btn.setText(quizArrayList.get(currentPos).getButton2());
        option3Btn.setText(quizArrayList.get(currentPos).getButton3());
        option4Btn.setText(quizArrayList.get(currentPos).getButton4());

    }
}