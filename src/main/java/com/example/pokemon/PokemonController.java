package com.example.pokemon;

import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/pokemon")
public class PokemonController {

  PokemonService pokemonService;

  public PokemonController(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @Get
  public List<Pokemon> getPokemon() throws PokemonValidateException {
    return pokemonService.get();
  }

  @Post
  public Pokemon createPokemon(@Body Pokemon pokemon) throws PokemonValidateException {
    return this.pokemonService.create(pokemon);
  }

  @Get("/{id}")
  public Pokemon getPokemonById(@PathVariable Integer id) throws PokemonValidateException {
    return this.pokemonService.getPokemonById(id);
  }

  @Put
  public Pokemon updatePokemonById(@Body Pokemon pokemon) throws PokemonValidateException {
    return this.pokemonService.updatePokemonById(pokemon);
  }

  @Delete("/{id}")
  public void deletePokemonById(@PathVariable Integer id) throws PokemonValidateException {
    this.pokemonService.deletePokemonById(id);
  }
}
