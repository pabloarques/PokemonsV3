package com.example.pokemons;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PokemonViewModel extends AndroidViewModel {

    private final Application app;
    private MutableLiveData<List<Pokemon>> pokemons;

    public PokemonViewModel(@NonNull Application application, Application app) {
        super(application);
        this.app = app;

    }

    public MutableLiveData<List<Pokemon>> getPokemons() {
        if(pokemons == null){
            pokemons = new MutableLiveData<>();
        }


        return pokemons;
    }

  /*  public void refresh(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());


        executor.execute(()-> {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

            PokeApi api = new PokeApi();
            ArrayList<Pokemon> pokemons = api.getPokemon();

        });
    }

*/
}

