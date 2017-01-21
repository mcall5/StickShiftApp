package com.example.android.stickshiftdraft;

import android.app.Activity;
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
import static android.os.Build.VERSION_CODES.M;
import static com.example.android.stickshiftdraft.R.id.detailsButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                            /*Start Button*/
        Button startButton = (Button) findViewById(R.id.start_start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(v.getContext(), FlashcardActivity.class);
                startActivity(startIntent);
            }
        });

                                    /*Menu Button*/
        Button menuButton = (Button) findViewById(R.id.start_menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent startIntent = new Intent(v.getContext(), MenuActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
