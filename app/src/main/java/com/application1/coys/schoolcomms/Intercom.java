package com.application1.coys.schoolcomms;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Intercom extends AppCompatActivity {

        EditText mTeacherName;
        EditText meditAnnouncement;
        RadioGroup radioGroup1;
        RadioButton radioButton2;
        String choice;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_intercom);
            meditAnnouncement = findViewById(R.id.editNote);
            meditAnnouncement.setImeOptions(EditorInfo.IME_ACTION_DONE);
            meditAnnouncement.setRawInputType(InputType.TYPE_CLASS_TEXT);
            mTeacherName = findViewById(R.id.editName);
            //allow for up navigation and back arrow at top of screen
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);//https://www.youtube.com/watch?v=EBRXkictWss
        }

    private String createIntercomSummary() {
        radioGroup1 = findViewById(R.id.radioGroup);

        // get selected radio button from radioGroup
        int selectedId = radioGroup1.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton2 = findViewById(selectedId);

        choice = radioButton2.getText().toString();

        String intercomAnnouncement = getString(R.string.teacher_name) + " " + mTeacherName.getText().toString();
        intercomAnnouncement  += "\n" + "\n" + getString(R.string.intercom_message_1);
        intercomAnnouncement  += "\n" + "Announcement :" + meditAnnouncement.getText().toString();
        intercomAnnouncement  += "\n" + "I would like the announcement to be made between " + choice;
        intercomAnnouncement  += "\n" + getString(R.string.intercom_message_end) + "\n" + mTeacherName.getText().toString();
        return intercomAnnouncement;


    }

    public void sendAnnouncementEmail(View v) {


        String teacherName = mTeacherName.getText().toString();
        if (teacherName.matches("")) {
            Toast.makeText(this, getString(R.string.teacher_name_blank), Toast.LENGTH_SHORT).show();

        }




         else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.to_email)});
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject_intercom));
            intent.putExtra(Intent.EXTRA_TEXT, createIntercomSummary());

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}
