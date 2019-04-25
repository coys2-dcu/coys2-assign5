package com.application1.coys.schoolcomms;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DailyNotes extends AppCompatActivity {
    EditText mTeacherName;
    EditText meditNote;
    CalendarView mCalendarView;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_notes);
        meditNote = findViewById(R.id.editNote);
        meditNote.setImeOptions(EditorInfo.IME_ACTION_DONE);
        meditNote.setRawInputType(InputType.TYPE_CLASS_TEXT);
        mTeacherName = findViewById(R.id.editName);
        CalendarView mCalendarView;

        //allow for up navigation and back arrow at top of screen
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);//https://www.youtube.com/watch?v=EBRXkictWss


        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()

        {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "/" + month + "/" + year;
                //Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
                            }
        });
    }


    private String createDailyNoteSummary() {

        String dailyNote = getString(R.string.teacher_name) + " " + mTeacherName.getText().toString();
        dailyNote += "\n" + "\n" + getString(R.string.daily_notes_message_1);
        dailyNote+= "\n" + "Note : " + meditNote.getText().toString();
        dailyNote  += "\n" + "I would like the note to be added on " + date ;
        dailyNote += "\n" + getString(R.string.intercom_message_end) + "\n" + mTeacherName.getText().toString();
        return dailyNote;


    }

    public void sendEmail(View v) {


        String teacherName = mTeacherName.getText().toString();
        if (teacherName.matches("")) {
            Toast.makeText(this,getString(R.string.teacher_name_blank), Toast.LENGTH_SHORT).show();

        } else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.to_email)});
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject_notes));
            intent.putExtra(Intent.EXTRA_TEXT, createDailyNoteSummary());

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}

