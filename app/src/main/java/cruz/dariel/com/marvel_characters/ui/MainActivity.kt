package cruz.dariel.com.marvel_characters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import cruz.dariel.com.marvel_characters.R
import cruz.dariel.com.marvel_characters.databinding.ActivityMainBinding
import cruz.dariel.com.marvel_characters.factory.HeroesViewModelFactory
import cruz.dariel.com.marvel_characters.network.RetrofitClient
import cruz.dariel.com.marvel_characters.repository.HeroeRepository
import cruz.dariel.com.marvel_characters.ui.heroeslist.HeroesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var heroesViewModel: HeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController)

        val heroesRepository = HeroeRepository(RetrofitClient())
        val factory = HeroesViewModelFactory(heroesRepository)
        heroesViewModel = ViewModelProvider(this, factory).get(HeroesViewModel::class.java)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
