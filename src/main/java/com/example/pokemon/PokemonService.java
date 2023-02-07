package com.example.pokemon;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  public Pokemon create(Pokemon pokemon) throws PokemonValidateException {
    Pokemon foundPokemon =
        get().stream()
            .filter(
                currPokemon ->
                    currPokemon.getName().toLowerCase().equals(pokemon.getName().toLowerCase()))
            .findFirst()
                .orElse(null);
    if (foundPokemon != null) {
      throw new PokemonValidateException("Pokemon name is already exists");
    }
    return this.pokemonRepository.save(pokemon);

  }

  public Pokemon getPokemonById(Integer id) throws PokemonValidateException {
    return this.pokemonRepository
        .findById(id)
        .orElseThrow(() -> new PokemonValidateException("No pokemon of this id"));
  }

  public Pokemon updatePokemonById(Pokemon pokemon) throws PokemonValidateException {
    getPokemonById(pokemon.getId());
    return this.pokemonRepository.update(pokemon);
  }

  public void deletePokemonById(Integer pokemonId) throws PokemonValidateException {
    getPokemonById(pokemonId);
    this.pokemonRepository.deleteById(pokemonId);
  }
}
