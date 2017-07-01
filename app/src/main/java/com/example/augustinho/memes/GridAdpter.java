package com.example.augustinho.memes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AUGUSTINHO on 29/06/2017.
 */

public class GridAdpter extends BaseAdapter {

    private int icons[];
    private String letters[];
    private Context context;
    private LayoutInflater inflater;


    public GridAdpter(Context context, int icons[], String letters []){
        this.context = context;
        this.icons = icons;
        this.letters = letters;
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int position) {
        return letters[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridview = convertView;

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

           gridview = inflater.inflate(R.layout.custom_layout, null);
        }
        ImageView icon = (ImageView) gridview.findViewById(R.id.icons);
        TextView letter = (TextView) gridview.findViewById(R.id.letters);

        icon.setImageResource(icons[position]);
        letter.setText(letters[position]);

        return gridview;
    }
}
