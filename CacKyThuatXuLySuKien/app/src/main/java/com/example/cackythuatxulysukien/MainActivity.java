package com.example.cackythuatxulysukien;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements android.view.View.OnLongClickListener {

    EditText txtA, txtB;
    Button btnTru;
    Button btnNhan, btnChia;
    Button btnAn;
    Button btnThoat;

    View.OnClickListener suKienChiaSe = null;

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
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepTru();
            }
        });

        suKienChiaSe = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btnNhan) {
                    xuLyPhepNhan();
                } else if(view.getId() == R.id.btnChia) {
                    xuLyPhepChia();
                }
            }
        };
        btnNhan.setOnClickListener(suKienChiaSe);
        btnChia.setOnClickListener(suKienChiaSe);

        btnAn.setOnLongClickListener(this);

        btnThoat.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepChia() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a/b;
        Toast toast = Toast.makeText(MainActivity.this, "Thuong = " + c, Toast.LENGTH_LONG);
        toast.show();
    }

    private void xuLyPhepNhan() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a*b;
        Toast toast = Toast.makeText(MainActivity.this, "Tich = " + c, Toast.LENGTH_LONG);
        toast.show();
    }

    private void xuLyPhepTru() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a-b;
        Toast toast = Toast.makeText(MainActivity.this, "Hieu = " + c, Toast.LENGTH_LONG);
        toast.show();
    }

    private void addControls() {
        txtA = this.<EditText>findViewById(R.id.txtA);
        txtB = this.<EditText>findViewById(R.id.txtB);
        btnTru = this.<Button>findViewById(R.id.btnTru);
        btnNhan = this.<Button>findViewById(R.id.btnNhan);
        btnChia = this.<Button>findViewById(R.id.btnChia);
        btnAn = this.<Button>findViewById(R.id.btnAn);
        btnThoat = this.<Button>findViewById(R.id.btnThoat);
    }

    public void xuLyPhepCong(View v) {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a+b;
        Toast toast = Toast.makeText(MainActivity.this, "Tong = " + c, Toast.LENGTH_LONG);
        toast.show();
    }

    public boolean onLongClick (View view) {
        if(view.getId() == R.id.btnAn) {
            btnAn.setVisibility(View.INVISIBLE);
        }
        return false;
    }

    public class MyEvent implements View.OnClickListener, View.OnLongClickListener {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btnThoat) {
                finish();
            }
        }

        @Override
        public boolean onLongClick(View view) {

            return false;
        }
    }

    public void xuLyDoiManHinh(View view) {
        @SuppressLint("AppCompatCustomView") Button btnMoi = new Button(MainActivity.this) {
            @Override
            public boolean performClick() {
                setContentView(R.layout.activity_main);
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });

                addControls();
                addEvents();

                return super.performClick();
            }
        };

        btnMoi.setText("Back");
        btnMoi.setWidth(200);
        btnMoi.setHeight(200);

        setContentView(btnMoi);
    }

}