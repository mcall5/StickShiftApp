package com.example.android.stickshiftdraft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.button;

public class FlashcardActivity extends AppCompatActivity {
    //Current Question #
    int listNumber = 1;
    //fact detail button
    public Button detailsButton;
    //End of list if == 1
    int listEnd = 0;
    //Answer displayed if == 1
    int answerDisplayed = 0;
    //Detail page displayed if ==1
    int detailDisplay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        Intent questionintent = getIntent();
        listNumber = questionintent.getIntExtra("list_number", 1);
        detailsButton = (Button) findViewById(R.id.detailsButton);
        //Display question message & image w/blank answer & reset global variables
        refreshQuesBlank();

                             /*   answer+next button */
        Button answerNextButton= (Button) findViewById(R.id.answer_next_button);
        answerNextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Display answer if answer is not displayed
                if (answerDisplayed == 0){
                    if (listEnd == 0){
                        getIdAndDisplay("answer_" + listNumber, "string", R.id.answer);
                        //Set answer message displayed to true
                        answerDisplayed = 1;
                        detailsButton.setEnabled(true);
                        detailDisplay = 1;
                    }
                }
                //If answer is already displayed
                else {
                    //Display next question if not at the end:
                    if (listNumber < 7){
                        listNumber = listNumber + 1;
                        //& reset global variables
                        refreshQuesBlank();
                    }
                    //Or display the finished screen if at the end:
                    else{
                        displayView(R.string.finish_question, R.id.question);
                        displayView(R.string.finish_answer, R.id.answer);
                        displayView(R.drawable.finishflag, R.id.fact_pic);
                        detailsButton.setEnabled(false);
                        //Set end of list as true
                        listEnd = 1;
                        //Set answer message displayed to false
                        answerDisplayed = 0;
                        detailDisplay = 0;
                    }
                }
            }
        });

                             /*   Back Button*/
        Button buttonBack= (Button) findViewById(R.id.backButton);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //If the displayed question is not the beginning
                if (listNumber > 1){
                    //And it is also not at the finish message
                    if (listEnd == 0){
                        //Set question # to previous #
                        listNumber = listNumber - 1;
                    }
                    //If it is at the finish message:
                    else {
                        //Set end of list to be false
                        listEnd = 0;
                    }
                    //Display question message & image w/blank answer & reset global variables
                    refreshQuesBlank();
                }
                //If the displayed question is at the beginning:
                else {
                    //Display an empty answer & set answer message displayed to false
                    displayView(R.string.blank_answer, R.id.answer);
                    answerDisplayed = 0;
                    detailsButton.setEnabled(false);
                }
            }
        });

                             /*   Details Button*/
        Button buttonDetails= (Button) findViewById(R.id.detailsButton);
        buttonDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //If next detail page exists:
                if (getResources().getIdentifier("detail_" + listNumber + "_page_" + detailDisplay, "string", getPackageName()) != 0) {
                    //Display & move to next page
                    getIdAndDisplay("detail_" + listNumber + "_page_" + detailDisplay, "string", R.id.answer);
                    detailDisplay = detailDisplay + 1;
                    return;
                }
                //Else: loop back to answer & reset detail page to beginning
                else {
                    getIdAndDisplay("answer_" + listNumber, "string", R.id.answer);
                    detailDisplay = 1;
                }
            }
        });

                             /*   Go back to Menu*/
        Button buttonFlashcardMenu= (Button) findViewById(R.id.flashcardMenu);
        buttonFlashcardMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent flashcardMenuIntent = new Intent(v.getContext(), MenuActivity.class);
                startActivity(flashcardMenuIntent);
            }
        });
    }


    /*Method to display question message & image w/blank answer & reset global variables*/
    private void refreshQuesBlank(){
        //Set question image
        getIdAndDisplay("question_" + listNumber, "drawable", R.id.fact_pic);
        //Display question text to "question" TextView
        getIdAndDisplay("question_" + listNumber, "string", R.id.question);
        //blank answer
        displayView(R.string.blank_answer, R.id.answer);
        //Reset variables to specify that it is not the end of question list and answer is not displayed
        globalVarReset();
    }
    /*Method for displaying strings & drawables
    * Input the name and type (string vs. drawable) to display & the view location to display it*/
    private void getIdAndDisplay(String name, String type, int locationId){
        int value = getResources().getIdentifier(name, type, getPackageName());
        displayView(value, locationId);
    }
    /*Method to display strings & drawable after finding the string/drawable resource*/
    public void displayView(int value, int locationId){
        //display drawable
        if ((getResources().getResourceTypeName(value).equals("drawable"))){
            ImageView imageView = (ImageView) findViewById(locationId);
            imageView.setImageResource(value);
            return;
        }
        //display string
        TextView textView = (TextView) findViewById(locationId);
        textView.setText(value);
    }

    /*Method to specify that the end of question list and answer message are both false*/
    private void globalVarReset() {
        listEnd = 0;
        answerDisplayed = 0;
        detailDisplay = 0;
        detailsButton.setEnabled(false);
    }
}