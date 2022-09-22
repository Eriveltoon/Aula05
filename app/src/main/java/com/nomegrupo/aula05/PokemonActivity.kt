package com.nomegrupo.aula05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.nomegrupo.aula05.databinding.ActivityPokemonBinding //import binding Automatico

class PokemonActivity : AppCompatActivity() {

    lateinit var binding: ActivityPokemonBinding //binding Automatico

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater) //binding Automatico
        setContentView(binding.root) //binding Automatico

        val pokemons  = arrayListOf("Escolha um Pokémon", "Bulbassauro", "Charmander", "Squirtle")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemons) //preenchendo spinner com o Array
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter //Ativa spinner com as opcoes do Array



        //Para tratamento das opcoes
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapter: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {
                when(posicao){
                    1 -> {
                        val imagemBulbassauro = getDrawable(R.drawable.bulbassauro)
                        binding.imageView.setImageDrawable(imagemBulbassauro)
                    }
                    2 -> {
                        val imagemCharmander = getDrawable(R.drawable.charmander)
                        binding.imageView.setImageDrawable(imagemCharmander)
                    }
                    3 -> {
                        val imagemSquirtle = getDrawable(R.drawable.squirtle)
                        binding.imageView.setImageDrawable(imagemSquirtle)
                    }
                    else -> binding.imageView.setImageDrawable(null)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.button.setOnClickListener {
            when(binding.spinner.selectedItemPosition){
                1 -> alert("Tipo do Pokémon","Planta",this)
                2 -> alert("Tipo do Pokémon","Fogo",this)
                3 -> alert("Tipo do Pokémon","Água",this)

                else -> alert("Erro", "Selecione um Pokémon", this)
            }
        }
    }
}