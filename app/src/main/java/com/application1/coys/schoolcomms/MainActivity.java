package com.application1.coys.schoolcomms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button icom = (Button) findViewById(R.id.intercomButton);
        icom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intercom();
            }
        });

        Button notes = (Button) findViewById(R.id.dNotesButton);
        icom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyNotes();
            }
        });
    }

    public void intercom() {
        // Do something in response to button
        Intent intent = new Intent(this, Intercom.class);
        startActivity(intent);

    }

    public void DailyNotes() {
        // Do something in response to button
        Intent intent = new Intent(this, DailyNotes.class);
        startActivity(intent);

    }
}


