package com.example;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {
    private List<Pokemon> store;
    private Integer nextPokemonId;

    public PokemonRepository() {
        this.store = new ArrayList<>();
        nextPokemonId = 1;
        create(new Pokemon(null, "Balbasaur", "123", "Grass"));
        create(new Pokemon(null, "Balbasaur", "123", "Grass"));

    }

    public List<Pokemon> get() {
        return this.store;
    }

    public Pokemon create(Pokemon pokemon) {
        pokemon.setId(nextPokemonId++);
        store.add(pokemon);
        return pokemon;
    }

    public Pokemon getPokemonById(Integer pokemonId) {
        return this.store.stream().filter(pokemon -> pokemon.getId().equals(pokemonId)).findFirst().orElse(null);
    }
}
