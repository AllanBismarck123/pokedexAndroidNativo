package br.com.projects.pokedex_android.model

import br.com.projects.pokedex_android.domain.Pokemon
import br.com.projects.pokedex_android.domain.PokemonType

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)

class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
