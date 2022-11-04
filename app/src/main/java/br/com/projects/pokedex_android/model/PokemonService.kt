package br.com.projects.pokedex_android.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") user: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number: Int): Call<PokemonApiResult>
}