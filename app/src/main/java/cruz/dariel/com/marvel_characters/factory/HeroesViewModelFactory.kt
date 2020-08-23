package cruz.dariel.com.marvel_characters.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cruz.dariel.com.marvel_characters.repository.HeroeRepository
import cruz.dariel.com.marvel_characters.ui.heroeslist.HeroesViewModel

class HeroesViewModelFactory(private val heroesRepository: HeroeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroesViewModel::class.java)) {
            return HeroesViewModel(heroesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}