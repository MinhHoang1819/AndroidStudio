package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import Model.NhanVien;

public class MainActivity extends AppCompatActivity {

    EditText txtTen, txtSoNgay;
    Button btnXacNhan;

    Spinner spThu;
    ArrayList<String> dsThu;
    ArrayAdapter<String> adapterThu;

    int lastedSelected = -1;

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
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXacNhan();
            }
        });

        spThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Ban chon " + dsThu.get(i), Toast.LENGTH_LONG).show();
                lastedSelected = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void xuLyXacNhan() {
        if(lastedSelected == -1) {
            Toast.makeText(MainActivity.this, "Moi ban chon thu", Toast.LENGTH_LONG).show();
            return;
        }

        NhanVien nv = new NhanVien();
        nv.setTen(txtTen.getText().toString());
        nv.setThu(dsThu.get(lastedSelected));
        nv.setSoNgay(Integer.parseInt(txtSoNgay.getText().toString()));

        Toast.makeText(MainActivity.this, nv.toString(), Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtTen = this.<EditText>findViewById(R.id.txtTen);
        txtSoNgay = this.<EditText>findViewById(R.id.txtSoNgay);
        btnXacNhan = this.<Button>findViewById(R.id.btnXacNhan);

        spThu = this.<Spinner>findViewById(R.id.spThu);
        dsThu = new ArrayList<>();
        dsThu.add("Thu 2");
        dsThu.add("Thu 3");
        dsThu.add("Thu 4");
        dsThu.add("Thu 5");
        dsThu.add("Thu 6");
        dsThu.add("Thu 7");
        dsThu.add("Chu nhat");

        adapterThu = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                dsThu
        );
        adapterThu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spThu.setAdapter(adapterThu);
    }
}