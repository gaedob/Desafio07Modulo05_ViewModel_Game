package com.desafiolatam.viewmodel

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.viewmodel.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private lateinit var viewModel: ViewmodelMainViewModel

    private val viewModel:  MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    // Inflar el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Manejar las acciones de los elementos del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Lógica para el ítem "Settings"
                // Llama a la función toggleActive del ViewModel
                viewModel.resetScores()
                viewModel.textViewText.value = "Click!"



                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}