/* MAIN ACTIVITY JAVA FILE */

package com.marksinventions.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Set> setsList;
    GridView setsGrid;
    SetsAdapter adapter;
    int setIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setsList = new ArrayList<>();
        adapter = new SetsAdapter(this, setsList);
        setsGrid = (GridView) findViewById(R.id.setsGrid);
        setsGrid.setAdapter(adapter);
        setsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("Click listener works. Set: " + i);
                setIndex = i;
                shortClick();
            }
        });
    }

    public void editSet(){

    }

    public void deleteSet(){
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
    public void newProject(View view) {
    }

    public void newSet(View view) {

        Intent intent = new Intent(this, Compose.class);
        startActivity(intent);

        /*
        setsList.add(new Set());
        System.out.println(setsList.size() + " elements");
        adapter.notifyDataSetChanged();
        */
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
        builder.setMessage("Delete this set?")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // setsList.remove(setIndex);
                        //adapter.notifyDataSetChanged();
                        // deleteSet();
                    }
                })
                .setNeutralButton("Edit Set", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


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