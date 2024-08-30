package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox chkAndroid, chkWindowsPhone, chkIOS;
    Button btnChon;
    TextView txtMonHoc;

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
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyChonMonHoc();
            }
        });
    }

    private void xuLyChonMonHoc() {
        String s = "";
        if(chkAndroid.isChecked()) {
            s += chkAndroid.getText().toString() + "\n";
        }

        if(chkWindowsPhone.isChecked()) {
            s += chkWindowsPhone.getText().toString() + "\n";
        }

        if(chkIOS.isChecked()) {
            s += chkIOS.getText().toString() + "\n";
        }

        txtMonHoc.setText(s);
    }

    private void addControls() {
        chkAndroid = this.<CheckBox>findViewById(R.id.chkAndroid);
        chkWindowsPhone = this.<CheckBox>findViewById(R.id.chkWindowsPhone);
        chkIOS = this.<CheckBox>findViewById(R.id.chkIOS);
        btnChon = this.<Button>findViewById(R.id.btnChon);
        txtMonHoc = this.<TextView>findViewById(R.id.txtMonHoc);

    }
}