package cruz.dariel.com.marvel_characters.ui.heroeslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cruz.dariel.com.marvel_characters.model.Character
import cruz.dariel.com.marvel_characters.repository.HeroeRepository

class HeroesViewModel(private var heroesRepository: HeroeRepository) : ViewModel() {

    val heroes: MutableLiveData<ArrayList<Character>> = heroesRepository.getHeroes()

}