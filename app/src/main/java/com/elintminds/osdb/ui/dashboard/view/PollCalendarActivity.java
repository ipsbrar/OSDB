package com.elintminds.osdb.ui.dashboard.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.calendarview.view.CalendarView;


import java.util.Calendar;

public class PollCalendarActivity extends BaseActivity {

    private CalendarView calendarView;
     private ImageView closeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeImg = (ImageView) findViewById(R.id.closeImg);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.addEvent(16,2,2019);
        calendarView.addEvent(17,2,2019);
        calendarView.addEvent(18,2,2019);
        calendarView.addEvent(19,2,2019);


        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        calendarView.setOnDayClickListener(new CalendarView.OnDayClickListener() {
            @Override
            public void onClick(int day, int month, int year, boolean hasEvent) {
                Toast.makeText(PollCalendarActivity.this, day+"/"+month+"/"+year + " hasEvent="+hasEvent, Toast.LENGTH_SHORT).show();
                if (hasEvent) {
                    //calendarView.deleteEvent(day, month, year);
                }
            }
        });

    }


    public void addEvent(View view) {
        String strDate = "";// editText.getText().toString();
        if (strDate.isEmpty()) {
            Toast.makeText(this, "define a day", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "date="+strDate, Toast.LENGTH_SHORT).show();

            String[] date = strDate.split("/");

            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            calendarView.addEvent(day, month, year);

        }
    }


    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setCalendarView(calendarView);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private CalendarView calendarView;

        public void setCalendarView(CalendarView calendarView) {
            this.calendarView = calendarView;
        }
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            calendarView.addEvent(day, month+1, year);
        }


    }
}
