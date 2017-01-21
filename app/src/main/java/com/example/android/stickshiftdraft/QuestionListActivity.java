package com.example.android.stickshiftdraft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;

public class QuestionListActivity extends AppCompatActivity {

    int listNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

                                        /*Question List Buttons*/
        Button questionButtonOne = (Button) findViewById(R.id.question_button_one);
        questionButtonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 1;
                activityLaunch();
//                Intent questionIntentOne = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentOne);
            }
        });
        Button questionButtonTwo = (Button) findViewById(R.id.question_button_two);
        questionButtonTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 2;
                activityLaunch();
//                Intent questionIntentTwo = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentTwo);
            }
        });
        Button questionButtonThree = (Button) findViewById(R.id.question_button_three);
        questionButtonThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 3;
                activityLaunch();
//                Intent questionIntentThree = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentThree);
            }
        });
        Button questionButtonFour = (Button) findViewById(R.id.question_button_four);
        questionButtonFour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 4;
                activityLaunch();
//                Intent questionIntentFour = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentFour);
            }
        });
        Button questionButtonFive = (Button) findViewById(R.id.question_button_five);
        questionButtonFive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 5;
                activityLaunch();
//                Intent questionIntentFive = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentFive);
            }
        });
        Button questionButtonSix = (Button) findViewById(R.id.question_button_six);
        questionButtonSix.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 6;
                activityLaunch();
//                Intent questionIntentSix = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentSix);
            }
        });
        Button questionButtonSeven = (Button) findViewById(R.id.question_button_seven);
        questionButtonSeven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listNumber = 7;
                activityLaunch();
//                Intent questionIntentSeven = new Intent(v.getContext(), FlashcardActivity.class);
//                startActivity(questionIntentSeven);
            }
        });
    }

    public void activityLaunch(){
        Intent questionIntent = new Intent(this, FlashcardActivity.class);
        questionIntent.putExtra("list_number", listNumber);
        startActivity(questionIntent);
    }

}
