package com.mauriciobenigno.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.mauriciobenigno.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.let {
            setContentView(it.root)
            val navController = getNavController()
            appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
            setupActionBarWithNavController(navController, appBarConfiguration)
        }

        //setContentView(binding.root)

        //setupActionBarWithNavController(navController)
    }

    /* Por conta da implementação de addMenuProvider, a ação Back não é passado diretamente para a activity
    * necessitando tratar por 'onMenuItemSelected' do provider, filtrando menuId com android.R.id.home
    * */
    override fun onSupportNavigateUp(): Boolean {
        val navController = getNavController()

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun getNavController() = (supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment).navController
}