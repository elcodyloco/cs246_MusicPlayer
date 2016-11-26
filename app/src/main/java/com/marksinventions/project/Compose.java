/* COMPOSE JAVA FILE */

package com.marksinventions.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static com.marksinventions.project.MainActivity.setsList;

public class Compose extends AppCompatActivity {
    final String ARRAY = "Array size: ";

    boolean edit = false;
    int currentSet; // holds int resource for the music files
    int resDrums; // holds int resource for the selected music file
    int resBass;
    int resGuitar;
    int resPiano;
    int resReps;
    int posDrums; // holds the selected int position of the spinner
    int posBass;
    int posGuitar;
    int posPiano;
    Button bPlay;
    Spinner sGuitar;
    Spinner sBass;
    Spinner sDrums;
    Spinner sPiano;
    Spinner sReps;

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
        sReps = (Spinner) findViewById(R.id.repsSpinner);

        ArrayAdapter gAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_guitar, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sGuitar.setAdapter(gAdapter);
        sGuitar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        resGuitar = -1;
                        posGuitar = 0;
                        break;
                    case 1:
                        resGuitar = R.raw.ambiant_b_maj;
                        posGuitar = 1;
                        break;
                    case 2:
                        resGuitar = R.raw.ambiant_e_maj;
                        posGuitar = 2;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter bAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_bass, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sBass.setAdapter(bAdapter);
        sBass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        resBass = -1;
                        posBass = 0;
                        break;
                    case 1:
                        resBass = R.raw.bass_low_e_octaves;
                        posBass = 1;
                        break;
                    case 2:
                        resBass = R.raw.bass_high_e_4_4;
                        posBass = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter dAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_drums, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDrums.setAdapter(dAdapter);
        sDrums.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        resDrums = -1;
                        posDrums = 0;
                        break;
                    case 1:
                        resDrums = R.raw.drum_bongo_4_4_120;
                        posDrums = 1;
                        break;
                    case 2:
                        resDrums = R.raw.drum_standard_4_4_120;
                        posDrums = 2;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter pAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_piano, android.R.layout.simple_spinner_dropdown_item);
        gAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sPiano.setAdapter(pAdapter);
        sPiano.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        resPiano = -1;
                        posPiano = 0;
                        break;
                    case 1:
                        resPiano = R.raw.piano_chords_e_maj;
                        posPiano = 1;
                        break;
                    case 2:
                        resPiano = R.raw.piano_synth_beat_e;
                        posPiano = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter rAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_reps, android.R.layout.simple_spinner_dropdown_item);
        rAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sReps.setAdapter(rAdapter);
        sReps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                resReps = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent intent = getIntent();
        if (intent.getExtras() != null) { // check if this is an edit, not a new set
            int currentSet = intent.getIntExtra("index", 0); // find the set to be edited
            edit = intent.getBooleanExtra("index", true); // set edit to true so save() will not create a new set
            Set tempSet = setsList.get(currentSet); // create a copy of the current set
            sBass.setSelection(tempSet.getB_Pos());// set the spinners to the values from the current set
            sDrums.setSelection(tempSet.getD_Pos());
            sGuitar.setSelection(tempSet.getG_Pos());
            sPiano.setSelection(tempSet.getP_Pos());
            sReps.setSelection(tempSet.getReps() - 1);
        }

    }// end of onCreate

    public void drums(View view) {
    }

    public void bass(View view) {
    }

    public void piano(View view) {
    }

    public void guitar(View view) {
    }

    public void save(View view) {
        Set tempSet;
        if (edit == false) { // new set. create set, add it to the arrayList and set it as the current set.
            tempSet = new Set();
            setsList.add(tempSet);
            currentSet = setsList.size() - 1;
        }
        tempSet = MainActivity.setsList.get(currentSet); // create a copy of the current set

        tempSet.setDrums(resDrums); // set all the values
        tempSet.setD_pos(posDrums);
        tempSet.setBass(resBass);
        tempSet.setB_Pos(posBass);
        tempSet.setGuitar(resGuitar);
        tempSet.setG_Pos(posGuitar);
        tempSet.setPiano(resPiano);
        tempSet.setP_Pos(posPiano);
        tempSet.setReps(resReps);

        setsList.set(currentSet, tempSet); // replace the current set with tempSet

        Intent intent = new Intent(this, MainActivity.class); // go back to main
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    public void cancel(View view) {
    }

    public void test(View view) {
    }

    public void stop(View view) {
    }
}