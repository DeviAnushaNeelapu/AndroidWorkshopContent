package com.example.dialogsandpickers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //c -> current
    int c_year,c_month,c_day;
    int c_hour,c_minuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Exit");
        builder.setMessage("Are you sure want to Exit ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                        finish();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                           dialog.dismiss();
            }
        });

        builder.show();

    }

    public void openDatePicker(View view) {
        Calendar c = Calendar.getInstance();
        c_year = c.get(Calendar.YEAR);
        c_month = c.get(Calendar.MONTH);
        c_day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String myDate = dayOfMonth+"-"+(month+1)+"-"+year;
                Toast.makeText(MainActivity.this,
                        myDate, Toast.LENGTH_SHORT).show();

            }
        },c_year,c_month,c_day);
        datePicker.show();
    }

    public void openTimePicker(View view) {
        Calendar c = Calendar.getInstance();
        c_hour = c.get(Calendar.HOUR_OF_DAY);
        c_minuite = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String myTime = hourOfDay+":"+minute;
                Toast.makeText(MainActivity.this,
                        myTime, Toast.LENGTH_SHORT).show();
            }
        },c_hour,c_minuite,false);
        timePickerDialog.show();

    }
}
