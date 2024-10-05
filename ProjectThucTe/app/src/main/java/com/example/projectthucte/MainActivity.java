package com.example.projectthucte;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import Adapter.MusicAdapter;
import Model.Music;

public class MainActivity extends AppCompatActivity {

    ListView lvBaiHatGoc;
    ArrayList<Music> dsBaiHatGoc;
    MusicAdapter adapterBaiHatGoc;

    ListView lvBaiHatYeuThich;
    ArrayList<Music> dsBaiHatYeuThich;
    MusicAdapter adapterBaiHatYeuThich;

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

    }

    private void addControls() {

        TabHost tabHost = this.<TabHost>findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab1.setContent(R.id.tab2);
        tab1.setIndicator("");
        tabHost.addTab(tab2);

        lvBaiHatGoc = this.<ListView>findViewById(R.id.lvBaiHatGoc);
        dsBaiHatGoc = new ArrayList<>();
        adapterBaiHatGoc = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatGoc
        );
        lvBaiHatGoc.setAdapter(adapterBaiHatGoc);

        lvBaiHatYeuThich = this.<ListView>findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich = new ArrayList<>();
        adapterBaiHatYeuThich = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatYeuThich
        );
        lvBaiHatYeuThich.setAdapter(adapterBaiHatYeuThich);

        giaLapBaiHat();
    }

    private void giaLapBaiHat() {
        dsBaiHatGoc.add(new Music("55555", "Khong yeu noi loi cay dang", "Ngot Ngao", true));
        dsBaiHatGoc.add(new Music("12345", "Long me", "Ngoc Son", true));
        dsBaiHatGoc.add(new Music("23524", "Rieng mot bau troi", "Tuan Ngoc", true));
        dsBaiHatGoc.add(new Music("54323", "Ly ca phe ban me", "Siublack", true));

        adapterBaiHatGoc.notifyDataSetChanged();
    }
}