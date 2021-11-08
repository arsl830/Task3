package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

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
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase()))
                    ;
                {
                    currentScore++;
                }
                questionAttempted++;
                  currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase()))
                    ;
                {
                    currentScore++;
                }
                questionAttempted++;
                  currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase()))
                    ;
                {
                    currentScore++;
                }
                questionAttempted++;
                 currentPos = random.nextInt(quizArrayList.size());
                setQuizQuestion(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase()))
                    ;
                {
                    currentScore++;
                }
                questionAttempted++;
                  currentPos = random.nextInt(quizArrayList.size());

                setQuizQuestion(currentPos);
            }

        });
    }
    private void  showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity2.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(ConstraintLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.textView2);
        scoreTV.setText("Your score is \n"+currentScore + "/10");
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void getQuizQuestion (ArrayList < Quiz > quizArrayList) {
        quizArrayList.add(new Quiz("aaaaa", "a", "b", "c", "d", "a"));
        quizArrayList.add(new Quiz("bbbbb", "a", "b", "c", "d", "a"));
        quizArrayList.add(new Quiz("ccccc", "a", "b", "c", "d", "a"));
        quizArrayList.add(new Quiz("ddddd", "a", "b", "c", "d", "a"));
    }
    private void setQuizQuestion ( int currentPos){
        noq.setText("Questions attempted: " + questionAttempted + "/10");
        if(questionAttempted==10){
            showBottomSheet();
        }
        else {
            questions.setText(quizArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizArrayList.get(currentPos).getButton1());
            option2Btn.setText(quizArrayList.get(currentPos).getButton2());
            option3Btn.setText(quizArrayList.get(currentPos).getButton3());
            option4Btn.setText(quizArrayList.get(currentPos).getButton4());
        }
    }
}
