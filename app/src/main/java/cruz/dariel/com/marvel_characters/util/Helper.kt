package cruz.dariel.com.marvel_characters.util

import cruz.dariel.com.marvel_characters.model.Image
import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String{
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun Image.getPath(): String{
    return "$path/portrait_medium.$extension".replace("http", "https")
}