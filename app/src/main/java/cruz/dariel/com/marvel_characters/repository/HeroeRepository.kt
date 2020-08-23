package cruz.dariel.com.marvel_characters.repository

import androidx.lifecycle.MutableLiveData
import cruz.dariel.com.marvel_characters.model.Character
import cruz.dariel.com.marvel_characters.model.CharacterDataWrapper
import cruz.dariel.com.marvel_characters.network.RetrofitClient
import cruz.dariel.com.marvel_characters.util.CalculatedValues
import cruz.dariel.com.marvel_characters.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroeRepository(private val clientService: RetrofitClient) {

    fun getHeroes(): MutableLiveData<ArrayList<Character>>{

        val heroes: MutableLiveData<ArrayList<Character>> = MutableLiveData()
        val hashMap = mapOf("ts" to CalculatedValues.ts,
            "apikey" to Constants.PUBLIC_API_KEY,
            "hash" to CalculatedValues.hash)
        clientService.marvelService.getHeroes(hashMap).enqueue(object : Callback<CharacterDataWrapper> {

            override fun onResponse(call: Call<CharacterDataWrapper>, response: Response<CharacterDataWrapper>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        heroes.value = it.data.results
                    }
                }
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                heroes.value = null
            }
        })

        return heroes
    }

}