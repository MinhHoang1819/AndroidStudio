package Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectthucte.R;

import java.util.List;

import Model.Music;

public class MusicAdapter extends ArrayAdapter<Music> {

    @NonNull
    Activity context;
    int resource;
    @NonNull
    List<Music> objects;
    public MusicAdapter(@NonNull Activity context, int resource, @NonNull List<Music> objects) {
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
        TextView txtMa = row.<TextView>findViewById(R.id.txtMa);
        TextView txtTen = row.<TextView>findViewById(R.id.txtTen);
        TextView txtCaSi = row.<TextView>findViewById(R.id.txtCaSi);
        ImageButton btnLike = row.<ImageButton>findViewById(R.id.btnLike);

        Music music = this.objects.get(position);
        txtMa.setText(music.getMa());
        txtTen.setText(music.getTen());
        txtCaSi.setText(music.getCaSi());

        return row;
    }
}
