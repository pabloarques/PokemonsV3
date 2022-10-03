package com.example.pokemons;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;

import com.example.pokemons.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.Inflater;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Pokemon> items;
    private ArrayAdapter<Pokemon> adapter;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        setHasOptionsMenu(true);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         items = new ArrayList<Pokemon>();
         adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_pokemon_row,
                R.id.txtPoke,
                items
        );

        binding.lvPokemon.setAdapter(adapter);
        refresh();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void refresh(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(()-> {
            PokeApi api = new PokeApi();
            ArrayList <Pokemon> pokemons = api.getPokemon();
            handler.post(()->{
                adapter.clear();
                adapter.addAll(pokemons);
             });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}