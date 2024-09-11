package com.example.autocompletetextview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtTen;

    AutoCompleteTextView autoTinhThanh;
    String []arrTinhThanh;
    ArrayAdapter<String> adapterTinhThanh;

    Button btnXacNhan;
    TextView txtThongTin;

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
    }

    private void xuLyXacNhan() {
        String s = txtTen.getText().toString() + "\n" + autoTinhThanh.getText().toString();
        txtThongTin.setText(s);
    }

    private void addControls() {
        txtTen = this.<EditText>findViewById(R.id.txtTen);
        btnXacNhan = this.<Button>findViewById(R.id.btnXacNhan);
        txtThongTin = this.<TextView>findViewById(R.id.txtThongTin);
        autoTinhThanh = this.<AutoCompleteTextView>findViewById(R.id.autotxtTinhThanh);
        arrTinhThanh = getResources().getStringArray(R.array.arrTinhThanh);
        adapterTinhThanh = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrTinhThanh
        );
        autoTinhThanh.setAdapter(adapterTinhThanh);
    }
}