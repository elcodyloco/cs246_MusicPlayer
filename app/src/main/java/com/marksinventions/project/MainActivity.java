package com.marksinventions.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String ARRAY = "Array size: ";
    static List<Set> setsList = new ArrayList<>();
    GridView setsGrid;
    SetsAdapter adapter;
    int setIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new SetsAdapter(this, setsList);
        setsGrid = (GridView) findViewById(R.id.setsGrid);
        setsGrid.setAdapter(adapter);
        setsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                setIndex = i;
                shortClick();
            }
        });
    }

    public void editSet() {
        Intent intent = new Intent(this, Compose.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("index", setIndex);
        intent.putExtra("edit", true);
        startActivity(intent);

    }

    public void deleteSet() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm Delete")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setsList.remove(setIndex);
                        adapter.notifyDataSetChanged();

                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        Log.i(ARRAY, "in Main onResume: " + Integer.toString(setsList.size()));

    }

    public void newProject(View view) {
    }

    public void newSet(View view) {

        Intent intent = new Intent(this, Compose.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void save(View view) {
    }

    public void load(View view) {

    }

    public void play(View view) {
    }

    public void stop(View view) {
    }

    public static int temp(int x, int y) {
        return x * y;
    }


    public void shortClick() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Select Action")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setNeutralButton("Edit Set", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        editSet();

                    }
                })
                .setNegativeButton("Delete Set", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteSet();

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}

