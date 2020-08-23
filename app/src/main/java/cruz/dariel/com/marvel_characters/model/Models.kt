package cruz.dariel.com.marvel_characters.model

data class CharacterDataWrapper(
    val code: Int = 0,
    val status: String = "",
    val data: CharacterDataContainer
)

data class CharacterDataContainer(
    val total: Int = 0,
    val count: Int = 0,
    val results: ArrayList<Character>
)

data class Character(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val thumbnail: Image? = null
)

data class Image(
    val path: String = "",
    val extension: String = ""
)