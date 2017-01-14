package com.example.android.stickshiftdraft;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {
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
    //Tag for logcat to follow lifeCycle
    final String TAG = "TKT";
    EditText zipInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////MAIN FACTS PAGE/////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /*Method to set up the main facts page.  Includes specified question to display*/
    private void setFactPage(){
        setContentView(R.layout.facts_main);
        detailsButton = (Button) findViewById(R.id.details);
        //Display question message & image w/blank answer & reset global variables
        refreshQuesBlank();
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
        //detailsButton.setVisibility(View.INVISIBLE);
        detailsButton.setEnabled(false);
    }

    /*onClick for answer+next button in facts_main.xml*/
    public void answerNextButton(View v) {
        //Display answer if answer is not displayed
        if (answerDisplayed == 0){
            if (listEnd == 0){
                getIdAndDisplay("answer_" + listNumber, "string", R.id.answer);
                //Set answer message displayed to true
                answerDisplayed = 1;
                //detailsButton.setVisibility(View.VISIBLE);
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
                //detailsButton.setVisibility(View.INVISIBLE);
                detailsButton.setEnabled(false);
                //Set end of list as true
                listEnd = 1;
                //Set answer message displayed to false
                answerDisplayed = 0;
                detailDisplay = 0;
            }
        }
    }

    /*onClick for back button in facts_main.xml*/
    public void backButton(View v) {
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
    /*onClick for detail button in facts_main.xml*/
    public void detailButton(View v){
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

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////FACTS LIST PAGE/////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    public void questionList(View v) {
        setContentView(R.layout.facts_list);
    }

    public void mainFacts(View v) {
        listNumber = 1;
        setFactPage();
    }
    public void factTwo(View v) {
        listNumber = 2;
        setFactPage();
    }

    public void factThree(View v) {
        listNumber = 3;
        setFactPage();
    }

    public void factFour(View v) {
        listNumber = 4;
        setFactPage();
    }
    public void factFive(View v) {
        listNumber = 5;
        setFactPage();
    }

    public void factSix(View v) {
        listNumber = 6;
        setFactPage();
    }

    public void factSeven(View v) {
        listNumber = 7;
        setFactPage();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////RESOURCE PAGE///////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////

    //onClick to Resource Page
    public void resourcePage(View v) {
        setContentView(R.layout.resources);
        zipInput = (EditText) findViewById(R.id.zip_Edit_Text);
    }

    //onClick to go to maps
    public void mapGo(View v) {
        String userZip = zipInput.getText().toString();
        if (userZip.length() == 0) {
            Toast noInput = Toast.makeText(getApplicationContext(), R.string.enter_location, Toast.LENGTH_SHORT);
            noInput.show();
        }
        else {
            String url = "https://www.google.com/maps/search/driving+school+" + userZip;
            Intent intent = new Intent(Intent.ACTION_VIEW );
            intent.setData(Uri.parse(url));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast orderMessage = Toast.makeText(getApplicationContext(), R.string.map_error, Toast.LENGTH_SHORT);
                orderMessage.show();
            }
       }
    }

    //onClick to go to youtube video search
    public void videoGo(View v){
        String url = "https://www.youtube.com/results?search_query=stick+shift+how+to";
        Intent intent = new Intent(Intent.ACTION_VIEW );
        intent.setData(Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast orderMessage = Toast.makeText(getApplicationContext(), R.string.video_error, Toast.LENGTH_SHORT);
            orderMessage.show();
        }
    }

    /////////////////////////////////MENU PAGE///////////////////////////////////////////////////
    //onClick to go to menu page
    public void mainMenu(View v){
        setContentView(R.layout.menu_main);
    }
}
