package com.example.augustinho.memes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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

        GridView gridView =(GridView)findViewById(R.id.gridview);
        GridAdpter adpter = new GridAdpter(MainActivity.this, letterIcons, letterList);
        gridView.setAdapter(adpter);

        //clique nos icones
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                //cria os audios
                MediaPlayer kiko = MediaPlayer.create(MainActivity.this, R.raw.kiko);
                MediaPlayer ruru = MediaPlayer.create(MainActivity.this, R.raw.rururu);
                MediaPlayer pa = MediaPlayer.create(MainActivity.this, R.raw.pa);

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
                    ruru = MediaPlayer.create(MainActivity.this, R.raw.rururu);
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
                    kiko = MediaPlayer.create(MainActivity.this, R.raw.kiko);
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
                    pa = MediaPlayer.create(MainActivity.this, R.raw.pa);
                }
            }

        }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void contato(MenuItem item) {
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Contato");
        builder.setMessage("auguscom@gmail.com");
        builder.setPositiveButton("Ok", null);
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    public void tv(MenuItem item) {
        Intent cat_tv = new Intent(MainActivity.this, cat_tv.class);
        startActivity(cat_tv);
    }


    public void page_desenhos(MenuItem item) {
        Intent cat_desenhos = new Intent(MainActivity.this, cat_desenhos.class);
        startActivity(cat_desenhos);
    }
}
