package com.example.pokemon;

import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/pokemon")
public class PokemonController {

  PokemonService pokemonService;

  public PokemonController() {
    this.pokemonService = new PokemonService();
  }

  @Get
  public List<Pokemon> getPokemon() {
    return pokemonService.get();
  }

  @Post
  public Pokemon createPokemon(@Body Pokemon pokemon) {
    return this.pokemonService.create(pokemon);
  }

  @Get("/{pokemonId}")
  public Pokemon getPokemonById(@PathVariable Integer pokemonId) {
    return this.pokemonService.getPokemonById(pokemonId);
  }

  @Put("/{id}")
  public Pokemon updatePokemonById(@PathVariable Integer id, @Body Pokemon pokemon) {
    return pokemonService.updatePokemonById(id, pokemon);
  }

  @Delete("/{id}")
  public boolean deletePokemonById(@PathVariable Integer id) {
    return this.pokemonService.deletePokemonById(id);
  }
}
