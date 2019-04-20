package com.example.htwkranapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;



public class KranSteuerung extends AppCompatActivity {
// Kran Funktionen
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


    // Menue fuehrung
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    openActivityKranSteuerung();




                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);

                    openActivityBlueTooth();

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);

                    openActivityInfo();

                    return true;
            }
            return false;
        }
    };
    // Menu verlinkung definieren
    public void openActivityInfo(){
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);

    }

    public void openActivityBlueTooth(){
        Intent intent = new Intent(this, BlueTooth.class);
        startActivity(intent);

    }

    public void openActivityKranSteuerung(){
        Intent intent = new Intent(this, KranSteuerung.class);
        startActivity(intent);

    }
    // Menu verlinkung defnieren ENDE
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kran_steuerung);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        // Kran Steuerung Funktionen
        seekFunctionLaufKatze();
        seekFunctionHohe();




    }

}
