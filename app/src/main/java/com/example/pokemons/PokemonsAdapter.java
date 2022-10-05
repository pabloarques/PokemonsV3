package com.example.pokemons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PokemonsAdapter extends ArrayAdapter<Pokemon> {
    public PokemonsAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Pokemon[] objects) {
        super(context, resource, textViewResourceId, objects);


    }

    public View getView(int position, View convertView, ViewGroup parent){

        Pokemon pokemon = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_pokemon_row, parent, false);
        }

        //union del codigo en las views del layout

        TextView txtPoke = convertView.findViewById(R.id.txtPoke);
        ImageView img_poke = convertView.findViewById(R.id.img_poke);

        txtPoke.setText(pokemon.getNombre());

        return convertView;
    }
}
