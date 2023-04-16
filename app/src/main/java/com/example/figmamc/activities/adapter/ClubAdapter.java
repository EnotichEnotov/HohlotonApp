package com.example.figmamc.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.figmamc.R;
import com.example.figmamc.activities.Entity.Club;

public class ClubAdapter extends ArrayAdapter<Club> {

    public ClubAdapter(Context context, Club[] arr) {
        super(context, R.layout.clubs_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Club month = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.clubs_item,null);
        }
        ((TextView) convertView.findViewById(R.id.name_club)).setText(String.valueOf(month.name));
        ((TextView) convertView.findViewById(R.id.type_of_club)).setText(String.valueOf(month.genre));
        //((ImageView) convertView.findViewById(R.id.avatarka)).setImageResource(month.avatarka);
        return convertView;
    }
}
