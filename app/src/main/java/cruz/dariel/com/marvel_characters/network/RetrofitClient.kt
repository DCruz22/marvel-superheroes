package cruz.dariel.com.marvel_characters.network

import cruz.dariel.com.marvel_characters.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val marvelService: MarvelService =
        retrofit.create(MarvelService::class.java)

}