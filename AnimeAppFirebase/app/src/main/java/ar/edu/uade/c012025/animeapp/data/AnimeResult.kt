package ar.edu.uade.c012025.animeapp.data

import com.google.gson.annotations.SerializedName

data class AnimeResult (
    val data: List<Anime>
)

data class AnimeDetailResult (
    val data: Anime
)

data class Anime (
    @SerializedName("mal_id")
    val id: Int = 0,
    val title: String = "",
    val synopsis: String= "",
    val images: Images = Images(ImagesJpg(""))
)

data class Images(
    val jpg: ImagesJpg = ImagesJpg("")
)

data class ImagesJpg(
    @SerializedName("image_url")
    val imageUrl: String= ""
)

fun emptyAnime() : Anime {
    return Anime(0, "", "", Images(ImagesJpg("")))
}