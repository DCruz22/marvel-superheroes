package cruz.dariel.com.marvel_characters.util

import cruz.dariel.com.marvel_characters.util.Constants.PRIVATE_API_KEY
import cruz.dariel.com.marvel_characters.util.Constants.PUBLIC_API_KEY

object Constants{
    const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
    const val PUBLIC_API_KEY = "fbc7a6d1027648d20d151aafa26dcbe9"
    const val PRIVATE_API_KEY = "ac9b697be5c76ef53d45d3cf80e6f2d4c5cb9696"
}

object CalculatedValues{
    var ts = (System.currentTimeMillis() / 1000).toString()
    var hash = (ts+PRIVATE_API_KEY+PUBLIC_API_KEY).md5()
}