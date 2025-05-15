package ar.edu.uade.c012025.animeapp.data

import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository

class AnimeRepository(
    val animeDataSource: IAnimeDataSource = AnimeApiDataSource()
) : IAnimeRepository
{
    override suspend fun fetchAnimes(search: String) : List<Anime> {
        return animeDataSource.getAnimeList(search)
    }

    override suspend fun fetchAnime(animeId: Int): Anime {
        return animeDataSource.getAnimeById(animeId)
    }
}