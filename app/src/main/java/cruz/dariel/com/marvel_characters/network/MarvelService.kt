package cruz.dariel.com.marvel_characters.network

import cruz.dariel.com.marvel_characters.model.CharacterDataWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MarvelService{

    @GET("characters")
    fun getHeroes(@QueryMap query:Map<String, String>): Call<CharacterDataWrapper>

}