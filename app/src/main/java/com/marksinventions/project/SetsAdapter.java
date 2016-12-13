package com.marksinventions.project;

import android.app.Activity;
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

        return listItemView;


    }

}

