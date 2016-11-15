package com.marksinventions.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Set> setsList;
    GridView  setsGrid ;
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
               /* AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Delete this set?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                setIndex = i;
                                deleteSet();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                            }
                        });
                AlertDialog dialog = builder.create();
               dialog.show(); */
            }
        });
               setsGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                   @Override
                   public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                       System.out.println("Long Click listener works. Set: " + i);
                       longClick(i);
               /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Delete this set?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               setIndex = i;
                                deleteSet();
                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                */

                       return false;


                   }
               });

           }


    public  void deleteSet(int i){
       setsList.remove(i);
       // adapter.notifyDataSetChanged();
    }
    public void newProject(View view) {
    }

    public void newSet(View view) {
        setsList.add(new Set());
        System.out.println(setsList.size()  + " elements");
        adapter.notifyDataSetChanged();
    }

    public void save(View view) {
    }

    public void load(View view) {
    }

    public void play(View view) {
    }

    public void stop(View view) {
    }

    public static int  temp(int x, int y){
        return x * y;
    }



    public void longClick(int i) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete this set?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        deleteSet(i);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // dialogInterface.cancel();

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();


        // Toast.makeText(this, "short click", Toast.LENGTH_LONG).show();
        }

    }

