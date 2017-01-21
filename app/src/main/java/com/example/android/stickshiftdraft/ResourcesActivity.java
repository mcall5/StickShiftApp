package com.example.android.stickshiftdraft;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.button;

public class ResourcesActivity extends AppCompatActivity {

    //Resource page map search input
    EditText zipInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        zipInput = (EditText) findViewById(R.id.zip_Edit_Text);

     /*   Go to Google Maps*/
        Button buttonMap= (Button) findViewById(R.id.map_button);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userZip = zipInput.getText().toString();
                if (userZip.length() == 0) {
                    Toast noInput = Toast.makeText(getApplicationContext(), R.string.enter_location, Toast.LENGTH_LONG);
                    noInput.show();
                }
                else {
                    String url = "https://www.google.com/maps/search/driving+school+" + userZip;
                    Intent intent = new Intent(Intent.ACTION_VIEW );
                    intent.setData(Uri.parse(url));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast orderMessage = Toast.makeText(getApplicationContext(), R.string.map_error, Toast.LENGTH_LONG);
                        orderMessage.show();
                    }
                }
            }
        });

             /*   Go to Youtube*/
        Button buttonVideo= (Button) findViewById(R.id.video_button);
        buttonVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "https://www.youtube.com/results?search_query=stick+shift+how+to";
                Intent intent = new Intent(Intent.ACTION_VIEW );
                intent.setData(Uri.parse(url));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast orderMessage = Toast.makeText(getApplicationContext(), R.string.video_error, Toast.LENGTH_LONG);
                    orderMessage.show();
                }
            }
        });

    }

}