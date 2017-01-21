package com.example.android.stickshiftdraft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Go to resources screen
        Button buttonResources= (Button) findViewById(R.id.resources_button);
        buttonResources.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resourceIntent = new Intent(v.getContext(), ResourcesActivity.class);
                startActivity(resourceIntent);
            }
        });

        //Go to question list screen
        Button buttonQuestionList= (Button) findViewById(R.id.question_list_button);
        buttonQuestionList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resourceIntent = new Intent(v.getContext(), QuestionListActivity.class);
                startActivity(resourceIntent);
            }
        });

        //Go to question list screen
        Button buttonMenuStart= (Button) findViewById(R.id.menu_start_button);
        buttonMenuStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resourceIntent = new Intent(v.getContext(), FlashcardActivity.class);
                startActivity(resourceIntent);
            }
        });
    }

}