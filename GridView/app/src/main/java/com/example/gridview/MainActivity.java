package com.example.gridview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import adapter.HinhAdapter;

public class MainActivity extends AppCompatActivity {

    GridView gvHinh;
    ArrayList<Integer> dsHinh;
    HinhAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            addControls();
            addEvents();
        });
    }

    private void addEvents() {

    }

    private void addControls() {
        gvHinh = this.<GridView>findViewById(R.id.gvHinh);
        
        dsHinh = new ArrayList<>();
        dsHinh.add(); dsHinh.add(); dsHinh.add(); dsHinh.add(); dsHinh.add();
        dsHinh.add(); dsHinh.add(); dsHinh.add(); dsHinh.add(); dsHinh.add();

        adapter = new HinhAdapter(MainActivity.this, R.layout.item, dsHinh);
        gvHinh.setAdapter(adapter);
    }
}