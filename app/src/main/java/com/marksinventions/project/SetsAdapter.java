package com.marksinventions.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Mark on 11/10/2016.
 */

public class SetsAdapter extends ArrayAdapter<Set> {


    public SetsAdapter(Activity context, List<Set> set) {
        super(context, 0, set);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.set_adapter, parent, false);
        }


       /* ImageButton setButton = (ImageButton) listItemView.findViewById(R.id.setButton);
        setButton.setTag(position);
        setButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();
                System.out.println("Click listener works Set: " + position);

                // MainActivity.shortClick(position);

            }
        });
        setButton.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                int position = (Integer) view.getTag();
                System.out.println("Long Click listener works. Set: " + position);
                longClick(position);
                return false;
            }
        });
        */


        return listItemView;


    }

    public void longClick(int i) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Delete this set?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                      //  MainActivity.deleteSet(i);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dialogInterface.cancel();

                    }
                });
    }


    }

