package com.example.pokemon;

import com.example.exception.PokemonValidateException;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    Optional<Pokemon> foundPokemon=pokemonRepository.findByNameIgnoreCase(pokemon.getName());
    if (foundPokemon.isPresent()) {
      throw new PokemonValidateException("Pokemon name is already exists");
    }
    return this.pokemonRepository.save(pokemon);
  }

  public Pokemon getPokemonById(Integer id) {
    return this.pokemonRepository
        .findById(id)
        .orElseThrow(() -> new PokemonValidateException("No pokemon of this id"));
  }

  public Pokemon updatePokemonById(Pokemon pokemon) {
    Optional<Pokemon> foundPokemon=pokemonRepository.findByNameIgnoreCase(pokemon.getName());

    if(foundPokemon.isPresent()){
      throw new PokemonValidateException("Pokemon already exists");
    }
    return this.pokemonRepository.update(pokemon);

  }

  public void deletePokemonById(Integer pokemonId) throws PokemonValidateException {
    getPokemonById(pokemonId);
    this.pokemonRepository.deleteById(pokemonId);
  }
}
