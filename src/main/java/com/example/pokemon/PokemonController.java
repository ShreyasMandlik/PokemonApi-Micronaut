package com.example.pokemon;

import com.example.exception.PokemonValidateException;
import io.micronaut.http.HttpResponse;
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
  public HttpResponse<Pokemon> createPokemon(@Body Pokemon pokemon) {

    Pokemon savedPokemon = this.pokemonService.create(pokemon);
    return HttpResponse.created(savedPokemon);
  }

  @Get("/{id}")
  public Pokemon getPokemonById(@PathVariable Integer id) {
    return this.pokemonService.getPokemonById(id);
  }

  @Put
  public Pokemon updatePokemonById(@Body Pokemon pokemon) {
    return this.pokemonService.updatePokemonById(pokemon);
  }

  @Delete("/{id}")
  public HttpResponse<String> deletePokemonById(@PathVariable Integer id) {
    this.pokemonService.deletePokemonById(id);
    return HttpResponse.ok();
  }
}
