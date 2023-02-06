package com.example.pokemon;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Integer> {








//  private List<Pokemon> store;
//  private Integer nextPokemonId;
//
//  public PokemonRepository() {
//    this.store = new ArrayList<>();
//    nextPokemonId = 1;
//    create(new Pokemon(null, "Balbasaur", "123", "Grass"));
//    create(new Pokemon(null, "Balbasaur", "123", "Grass"));
//  }
//
//  public List<Pokemon> get() {
//    return this.store;
//  }
//
//  public Pokemon create(Pokemon pokemon) {
//    pokemon.setId(nextPokemonId++);
//    store.add(pokemon);
//    return pokemon;
//  }
//
//  public Pokemon getPokemonById(Integer pokemonId) {
//    return this.store.stream()
//        .filter(pokemon -> pokemon.getId().equals(pokemonId))
//        .findFirst()
//        .orElse(null);
//  }
//
//  public Pokemon updatePokemonById(Integer pokemonId, Pokemon pokemon) {
//    Pokemon foundPokemon = getPokemonById(pokemonId);
//    if (foundPokemon != null) {
//      foundPokemon.update(pokemon);
//    }
//    return foundPokemon;
//  }
//
//  public boolean deletePokemonById(Integer pokemonId) {
//    store =
//        store.stream()
//            .filter(pokemon -> !pokemon.getId().equals(pokemonId))
//            .collect(Collectors.toList());
//    return true;
//  }
}
