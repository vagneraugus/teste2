package com.example.augustinho.memes;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class cat_desenhos extends AppCompatActivity {

    String letterList []={
            "","","","","","","","","","","","","","","","","","","","","","","",""
    };

    int letterIcons [] ={
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5,
            R.drawable.i6,
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9,
            R.drawable.i10,
            R.drawable.i11,
            R.drawable.i12,
            R.drawable.i13,
            R.drawable.i14,
            R.drawable.i15,
            R.drawable.i16,
            R.drawable.i17,
            R.drawable.i18,
            R.drawable.i19,
            R.drawable.i20,
            R.drawable.i21,
            R.drawable.i22,
            R.drawable.i23,
            R.drawable.i24
    };

    GridView gridView;
    String status = "play";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView =(GridView)findViewById(R.id.gridviewCat_desenhos);
        GridAdpter adpter = new GridAdpter(cat_desenhos.this, letterIcons, letterList);
        gridView.setAdapter(adpter);

        //clique nos icones
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //cria os audios
            MediaPlayer kiko = MediaPlayer.create(cat_desenhos.this, R.raw.kiko);
            MediaPlayer ruru = MediaPlayer.create(cat_desenhos.this, R.raw.rururu);
            MediaPlayer pa = MediaPlayer.create(cat_desenhos.this, R.raw.pa);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //ruru
                if (position == 4) {
                    if (status.toString().equals("play")) {
                        status = "pause";
                        ruru.start();
                    } else {
                        status = "play";
                        ruru.stop();
                        ruru = MediaPlayer.create(cat_desenhos.this, R.raw.rururu);
                    }
                }
                //choro kiko
                if (position == 2) {
                    if (status.toString().equals("play")) {
                        status = "pause";
                        kiko.start();
                    } else {
                        status = "play";
                        kiko.stop();
                        kiko = MediaPlayer.create(cat_desenhos.this, R.raw.kiko);
                    }
                }
                //panificadora alfa
                if (position == 3) {
                    if (status.toString().equals("play")) {
                        status = "pause";
                        pa.start();
                    } else {
                        status = "play";
                        pa.stop();
                        pa = MediaPlayer.create(cat_desenhos.this, R.raw.pa);
                    }
                }

            }
        });
    }
}
