package ar.edu.uade.c012025.animeapp.data

interface IAnimeDataSource {
    suspend fun getAnimeList() : List<Anime>
}