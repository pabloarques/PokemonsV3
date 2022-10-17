package com.example.pokemons;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PokeApi {

    ArrayList<Pokemon> getPokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon/";

        try {
            String result = HttpUtils.get(url);
            JSONObject jsonResult = new JSONObject(result);
            JSONArray results = jsonResult.getJSONArray("results");

            ArrayList<Pokemon> pokearray = new ArrayList<>();

            for (int i = 0; i < results.length(); i++) {
                JSONObject pokemonJson = results.getJSONObject(i);
                Pokemon pokemon = new Pokemon();

                pokemon.setNombre(pokemonJson.getString("name"));
                pokemon.setDetailsURL(pokemonJson.getString("url"));

                String resultDetails = HttpUtils.get(pokemon.getDetailsURL());
                JSONObject jsonDetails = new JSONObject(resultDetails);

                //Recorrer para llegar hasta la imagen
                JSONObject sprites = jsonDetails.getJSONObject("sprites");
                String spriteDefault = sprites.getString(("front_default"));
                pokemon.setImage(spriteDefault);

                pokemon.setPeso(jsonDetails.getInt("height"));

                //PETA LA APP AQUI HAY QUE MIRAR QUE FALLA
             /*  JSONObject types = jsonDetails.getJSONObject("types");
               JSONObject contenidoType = jsonDetails.getJSONObject("0");
               String type = contenidoType.getString("name");
               pokemon.setTipo(type);
            */

                pokearray.add(pokemon);
            }

            return pokearray;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
