/* COMPOSE JAVA FILE */

package com.marksinventions.project;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import static com.marksinventions.project.MainActivity.setsList;

public class Compose extends AppCompatActivity {
    final String ARRAY = "Array size: ";
    MediaPlayer drumPlayer;
    MediaPlayer bassPlayer;
    MediaPlayer pianoPlayer;
    MediaPlayer guitarPlayer;
    MediaPlayer mediaPlayer;
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
    SoundPool InstrumentPool;


    int drumId = 0;
    int bassId = 0;
    int pianoId = 0;
    int guitarId = 0;

    Spinner sGuitar;
    Spinner sBass;
    Spinner sDrums;
    Spinner sPiano;
    Spinner sReps;


    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

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
                        break;
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
        if (intent.getExtras() != null) { //  if true, this is an edit, not a new set
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
        releaseMediaPlayer();
        if (resDrums != -1) {
            mediaPlayer = MediaPlayer.create(this, resDrums);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }

    public void bass(View view) {
        releaseMediaPlayer();
        if (resBass != -1) {
            mediaPlayer = MediaPlayer.create(this, resBass);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }

    public void piano(View view) {
        System.out.println("Guitar resource " + resGuitar);
        releaseMediaPlayer();
        if (resPiano != -1) {
            mediaPlayer = MediaPlayer.create(this, resPiano);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }

    public void guitar(View view) {
        releaseMediaPlayer();
        if (resGuitar != -1) {
            mediaPlayer = MediaPlayer.create(this, resGuitar);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(completionListener);
        }
    }


    public void save(View view) {
        Set tempSet;
        if (!edit) { // new set. create set, add it to the arrayList and set it as the current set.
            tempSet = new Set();
            setsList.add(tempSet);
            currentSet = setsList.size() - 1;
        }
        tempSet = setsList.get(currentSet); // create a copy of the current set

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

        finish();

    }

    public void finish() {
        Intent intent = new Intent(this, MainActivity.class); // go back to main
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void cancel(View view) {
        finish();
    }

    public void play(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            InstrumentPool = new SoundPool.Builder()
                    .setMaxStreams(4)
                    .build();
        }

        int drumId = 0;
        int bassId = 0;
        int pianoId = 0;
        int guitarId = 0;

        if (resDrums != -1) drumId = InstrumentPool.load(this, resDrums, 0);
        if (resBass != -1) bassId = InstrumentPool.load(this, resBass, 0);
        if (resPiano != -1) pianoId = InstrumentPool.load(this, resPiano, 0);
        if (resGuitar != -1) guitarId = InstrumentPool.load(this, resGuitar, 0);

        if (resDrums != -1) drumId = InstrumentPool.play(drumId, 1, 1, 0, resReps, 1);
        if (resBass != -1) bassId = InstrumentPool.play(bassId, 1, 1, 0, resReps, 1);
        if (resPiano != -1) pianoId = InstrumentPool.play(pianoId, 1, 1, 0, resReps, 1);
        if (resGuitar != -1) guitarId = InstrumentPool.play(guitarId, 1, 1, 0, resReps, 1);
    }

    public boolean isDrumLoaded = false;
    public boolean isBassLoaded = false;
    public boolean isPianoLoaded = false;
    public boolean isGuitarLoaded = false;
    
    public void onLoadComplete(SoundPool InstrumentPool, int sampleId, int status){
    if (status == 0) {
        switch (sampleId) {
            case 2:
                isDrumLoaded = true;
                break;
            case 3:
                isBassLoaded = true;
                break;
            case 4:
                isPianoLoaded = true;
                break;
            case 5:
                isGuitarLoaded = true;
                break;
        }
    }
}

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}