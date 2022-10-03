package com.example.pokemons;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class PokemonsAdapter extends ArrayAdapter<Pokemon> {
    public PokemonsAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Pokemon[] objects) {
        super(context, resource, textViewResourceId, objects);


    }

    public View getView(int position, View convertView, ViewGroup parent){

        Pokemon pokemon = getItem(position);





        return convertView;
    }
}
