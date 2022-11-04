package br.com.projects.pokedex_android.model

import br.com.projects.pokedex_android.domain.Pokemon
import br.com.projects.pokedex_android.domain.PokemonType

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)

data class PokemonApiResult(
    val name: String,
    val types: PokemonTypeSlot
)

class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
