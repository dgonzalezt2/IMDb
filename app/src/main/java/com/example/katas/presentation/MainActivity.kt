package com.example.katas.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.katas.R
import com.example.katas.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        binding.bottomNavigation.setupWithNavController(navController)

        // Manejar la navegación manualmente
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {    navController.navigate(R.id.page_inicio)
                    true
                }
                R.id.nav_search -> {
                    navController.navigate(R.id.page_buscar)
                    true
                }
                R.id.nav_play -> {
                    navController.navigate(R.id.page_play)
                    true
                }
                R.id.nav_user -> {
                    navController.navigate(R.id.page_perfil)
                    true
                }
                else -> false
            }
        }
    }
}
