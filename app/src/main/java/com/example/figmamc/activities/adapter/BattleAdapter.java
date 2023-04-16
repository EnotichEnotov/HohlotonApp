package com.example.figmamc.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.figmamc.R;
import com.example.figmamc.activities.Entity.Battle;
import com.example.figmamc.activities.Entity.Club;

public class BattleAdapter extends ArrayAdapter<Battle> {

    public BattleAdapter(Context context, Battle[] arr) {
        super(context, R.layout.battles_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Battle battle = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.clubs_item,null);
        }
        ((TextView) convertView.findViewById(R.id.name)).setText(String.valueOf(battle.name));
        ((TextView) convertView.findViewById(R.id.votes_num)).setText(String.valueOf(battle.votes_num));
        ((TextView) convertView.findViewById(R.id.type)).setText(String.valueOf(battle.type));
        ((ImageView) convertView.findViewById(R.id.image)).setImageResource(battle.image);
        return convertView;
    }
}