package com.example.pokemon;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class PokemonService {

  PokemonRepository pokemonRepository;

  public PokemonService(PokemonRepository pokemonRepository) {
    this.pokemonRepository = pokemonRepository;
  }

  public List<Pokemon> get() {
    List<Pokemon> pokemons = new ArrayList<Pokemon>();
    for (Pokemon pokemon : pokemonRepository.findAll()) {
      pokemons.add(pokemon);
    }
    return pokemons;
  }

  public Pokemon create(Pokemon pokemon) {
    return this.pokemonRepository.save(pokemon);
  }

  //  public Pokemon getPokemonById(Integer pokemonId) {
  //    return this.pokemonRepository.getPokemonById(pokemonId);
  //  }
  //
  //  public Pokemon updatePokemonById(Integer pokemonId, Pokemon pokemon) {
  //    return pokemonRepository.updatePokemonById(pokemonId, pokemon);
  //  }

  //  public boolean deletePokemonById(Integer pokemonId) {
  //    return this.pokemonRepository.deletePokemonById(pokemonId);
  //  }
}
