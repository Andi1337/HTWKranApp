package com.example.htwkranapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // eigene Funktionen
    Switch simpleSwitch;








    public void seekFunctionLaufKatze() {
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        final TextView status = (TextView)findViewById(R.id.status);
        final TextView prog = (TextView)findViewById(R.id.progress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog.setText("  Laufkatze: "+ progress +" % Ausgefahren");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                status.setText("   Laufkatze wird bewegt.");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                status.setText("   Laufkatze steht.");
            }
        });
    }

    public void seekFunctionHohe() {
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar2);
        final TextView status = (TextView)findViewById(R.id.status2);
        final TextView prog = (TextView)findViewById(R.id.progress2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog.setText("  Hebehöhe: "+ progress +" % ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                status.setText("   Gewicht wird gehoben.");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                status.setText("   Gewicht steht.");
            }
        });
    }
//*
   // 3te SeekBar










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Relecanter Code (Selbst geschrieben)
        simpleSwitch = (Switch) findViewById(R.id.app_bar_switch);

// check current state of a Switch (true or false).
    //    Boolean switchState = simpleSwitch.isChecked();
     //   simpleSwitch.setText("Meeep");



        seekFunctionLaufKatze();
        seekFunctionHohe();








        // Relevanter Code Ende
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
        getMenuInflater().inflate(R.menu.test, menu);
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

        if (id == R.id.nav_send) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
