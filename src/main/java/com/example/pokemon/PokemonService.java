package com.example.pokemon;

import java.util.List;

public class PokemonService {

  PokemonRepository pokemonRepository;

  public PokemonService() {
    this.pokemonRepository = new PokemonRepository();
  }

  public List<Pokemon> get() {
    return this.pokemonRepository.get();
  }

  public Pokemon create(Pokemon pokemon) {
    return this.pokemonRepository.create(pokemon);
  }

  public Pokemon getPokemonById(Integer pokemonId) {
    return this.pokemonRepository.getPokemonById(pokemonId);
  }

  public Pokemon updatePokemonById(Integer pokemonId, Pokemon pokemon) {
    return pokemonRepository.updatePokemonById(pokemonId, pokemon);
  }

  public boolean deletePokemonById(Integer pokemonId) {
    return this.pokemonRepository.deletePokemonById(pokemonId);
  }
}
