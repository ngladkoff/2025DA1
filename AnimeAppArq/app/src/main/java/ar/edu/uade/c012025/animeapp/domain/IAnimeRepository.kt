package ar.edu.uade.c012025.animeapp.domain

import ar.edu.uade.c012025.animeapp.data.Anime

interface IAnimeRepository {
    suspend fun fetchAnimes() : List<Anime>
}