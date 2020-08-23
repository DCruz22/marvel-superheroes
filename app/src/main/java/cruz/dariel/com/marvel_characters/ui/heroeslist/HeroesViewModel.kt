package cruz.dariel.com.marvel_characters.ui.heroeslist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cruz.dariel.com.marvel_characters.model.Character
import cruz.dariel.com.marvel_characters.repository.HeroeRepository

class HeroesViewModel(private var heroesRepository: HeroeRepository) : ViewModel() {

    val heroes: MutableLiveData<ArrayList<Character>> = heroesRepository.getHeroes()
    val hero = MediatorLiveData<Character>()
    private val heroId: MutableLiveData<Int> = MutableLiveData()

    init{
        hero.addSource(heroId){
            it?.let {id ->
                hero.value = heroes.value!!.filter {  it.id == id}[0]
            }
        }
    }

    fun setHeroId(id: Int){
        heroId.value = id
    }
}