package ar.edu.uade.c012025.animeapp.data

import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository

class AnimeRepository(
    val animeDataSource: IAnimeDataSource = AnimeTestDataSource()
) : IAnimeRepository
{
    override suspend fun fetchAnimes() : List<Anime> {
        return animeDataSource.getAnimeList()
    }
}