package com.example;

import io.micronaut.http.annotation.*;
import io.netty.util.internal.logging.Slf4JLoggerFactory;

import java.util.List;
import java.util.logging.Logger;

@Controller("/pokemon")
public class PokemonController {

    PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Get
    public List<Pokemon> getPokemon() {
        return pokemonService.get();
    }

    @Post
    public Pokemon createPokemon(@Body Pokemon pokemon){
        return this.pokemonService.create(pokemon);
    }

    @Get("/{pokemonId}")
    public Pokemon getPokemonById(@QueryValue Integer pokemonId){
        return this.pokemonService.getPokemonById(pokemonId);

    }

    @Put("/{pokemonId}")
    public Pokemon putPokemonById(@Body Pokemon pokemon,@QueryValue Integer pokemonId){
        return this.pokemonService.updatePokemonById(pokemonId,pokemon);
    }

}
