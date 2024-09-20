package com.example.datepicker_timepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtDate, txtTime;
    Button btnDate, btnTime;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyHienThiDate();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyHienThiTime();
            }
        });
    }

    private void xuLyHienThiTime() {
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(Calendar.HOUR, i);
                calendar.set(Calendar.MINUTE, i1);
                txtTime.setText(sdf2.format(calendar.getTime()));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                MainActivity.this,
                listener,
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                true
        );

        timePickerDialog.show();
    }

    private void xuLyHienThiDate() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                txtDate.setText(sdf1.format(calendar.getTime()));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    @SuppressLint("WrongViewCast")
    private void addControls() {
        txtDate = this.<TextView>findViewById(R.id.txtDate);
        txtTime = this.<TextView>findViewById(R.id.txtTime);
        btnDate = this.<Button>findViewById(R.id.btnDate);
        btnTime = this.<Button>findViewById(R.id.btnTime);

        calendar = Calendar.getInstance();
        txtDate.setText(sdf1.format(calendar.getTime()));
        txtTime.setText(sdf2.format(calendar.getTime()));
    }

}