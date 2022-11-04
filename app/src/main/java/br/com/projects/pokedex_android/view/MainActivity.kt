package br.com.projects.pokedex_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.projects.pokedex_android.R
import br.com.projects.pokedex_android.api.PokemonRepository
import br.com.projects.pokedex_android.domain.Pokemon
import br.com.projects.pokedex_android.domain.PokemonType

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvpokemons)

//        val charmander = Pokemon(
//            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/004.png",
//            4,
//            "Charmander",
//            listOf(
//                PokemonType("Fire")
//            )
//        )
//
//        val pokemons = listOf(
//            charmander,
//            charmander,
//            charmander,
//            charmander,
//            charmander
//        )

        Thread(Runnable {
            loadPokemons()
        }).start()
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {
            val layoutManager = LinearLayoutManager(this)

            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(it)
            }
        }
    }
}