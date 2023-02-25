package com.mauriciobenigno.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.mauriciobenigno.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.let {
            setContentView(it.root)
            val navController = getNavController()
            setupActionBarWithNavController(navController)
        }

        //setContentView(binding.root)

        //setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = getNavController()

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun getNavController() = (supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment).navController
}