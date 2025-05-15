package ar.edu.uade.c012025.animeapp.data

interface IAnimeDataSource {
    suspend fun getAnimeList(search: String) : List<Anime>
    suspend fun getAnimeById(animeId: Int) : Anime
}