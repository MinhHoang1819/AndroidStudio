package com.example.datepicker_timepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

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
    }

    private void xuLyHienThiDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog()
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