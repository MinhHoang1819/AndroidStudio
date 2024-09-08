package Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewnangcao.R;

import java.util.List;

import Model.DanhBa;

public class AdapterDanhBa extends ArrayAdapter<DanhBa> {

    //Doi so 1: man hinh su dung layout nay (giao dien nay)
    Activity context;
    //layout cho tung dong muon hien thi (lam theo khach hang)
    int resource;
    //Danh sach nguon du lieu muon hien thi len giao dien
    List<DanhBa> objects;
    public AdapterDanhBa(@NonNull Activity context, int resource, @NonNull List<DanhBa> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtTen = row.<TextView>findViewById(R.id.txtTen);
        TextView txtPhone = row.<TextView>findViewById(R.id.txtPhone);
        ImageButton btnCall = row.<ImageButton>findViewById(R.id.btnCall);
        ImageButton btnSMS = row.<ImageButton>findViewById(R.id.btnSMS);
        ImageButton btnDetail = row.<ImageButton>findViewById(R.id.btnDetail);

        //Tra ve danh ba hien tai muon ve
        DanhBa danhBa = this.objects.get(position);
        txtTen.setText(danhBa.getTen());
        txtPhone.setText(danhBa.getPhone());

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyChiTiet(danhBa);
            }
        });

        return row;
    }

    private void xuLyChiTiet(DanhBa danhBa) {
        Toast.makeText(this.context, "Ban chon: "+danhBa.getTen(), Toast.LENGTH_LONG).show();
    }
}
