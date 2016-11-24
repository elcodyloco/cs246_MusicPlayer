/* COMPOSE JAVA FILE */

package com.marksinventions.project;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;
import java.util.ArrayList;

public class Compose extends AppCompatActivity {

    Button bPlay;

    Spinner sGuitar;
    Spinner sBass;
    Spinner sDrums;
    Spinner sPiano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        bPlay = (Button) findViewById(R.id.playGuitar);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        sGuitar = (Spinner) findViewById(R.id.guitarSpinner);
        sBass = (Spinner) findViewById(R.id.bassSpinner);
        sDrums = (Spinner) findViewById(R.id.drumSpinner);
        sPiano = (Spinner) findViewById(R.id.pianoSpinner);

        ArrayAdapter gAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_guitar, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sGuitar.setAdapter(gAdapter);

        ArrayAdapter bAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_bass, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBass.setAdapter(bAdapter);

        ArrayAdapter dAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_drums, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDrums.setAdapter(dAdapter);

        ArrayAdapter pAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_piano, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sPiano.setAdapter(pAdapter);

    }
}