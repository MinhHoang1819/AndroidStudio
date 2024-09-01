package com.example.radiobutton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton radRatTuyetVoi, radTuyetVoi, radTamChapNhan, radKhongTotLam;
    Button btnBinhChon;

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
        btnBinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyBinhChon();
            }
        });
    }

    private void xuLyBinhChon() {
        String s="";
        if(radRatTuyetVoi.isChecked()) {
            s = radRatTuyetVoi.getText().toString();
        }else if(radTuyetVoi.isChecked()) {
            s = radTuyetVoi.getText().toString();
        }else if(radTamChapNhan.isChecked()) {
            s = radTamChapNhan.getText().toString();
        }else if(radKhongTotLam.isChecked()) {
            s = radKhongTotLam.getText().toString();
        }

        Toast.makeText(MainActivity.this, "Ban chon: " + s, Toast.LENGTH_LONG).show();

    }

    private void addControls() {
        radRatTuyetVoi = this.<RadioButton>findViewById(R.id.radRatTuyetVoi);
        radTuyetVoi = this.<RadioButton>findViewById(R.id.radTuyetVoi);
        radTamChapNhan = this.<RadioButton>findViewById(R.id.radTamChapNhan);
        radKhongTotLam = this.<RadioButton>findViewById(R.id.radKhongTotLam);
        btnBinhChon = this.<Button>findViewById(R.id.btnBinhChon);
    }
}