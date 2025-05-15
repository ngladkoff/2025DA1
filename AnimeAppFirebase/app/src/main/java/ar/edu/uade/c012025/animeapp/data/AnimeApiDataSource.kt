package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import okio.IOException
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.tasks.await

class AnimeApiDataSource : IAnimeDataSource {
    private val TAG = "AnimeApp"

    override suspend fun getAnimeList(search: String): List<Anime> {
        Log.d(TAG, "AnimeApiDataSource.getAnimeList")

        return try {
            Log.d(TAG, "AnimeApiDataSource.getAnimeList Search: $search")
            val animeResult = RetrofitInstance.animeApi.getAnimeSearch(search)
            Log.d(TAG, "AnimeApiDataSource.getAnimeList Result: ${animeResult.data.size}")
            return animeResult.data
        } catch (e: HttpException) {
            Log.e(TAG, "Error de HTTP: ${e.code()} ${e.message()}")
            emptyList()
        } catch (e: IOException) {
            Log.e(TAG, "Error de Network: ${e.localizedMessage}")
            emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error desconocido: ${e.localizedMessage}")
            emptyList()
        }
    }

    override suspend fun getAnimeById(animeId: Int): Anime {

        Log.d("ANIMEDB", "getAnimeById")

        val db = FirebaseFirestore.getInstance()

        var animeResult = db.collection("Favoritos").document(animeId.toString()).get().await()
        var anime = animeResult.toObject(Anime::class.java)
        if (anime != null) {
            Log.d("ANIMEDB", "encontrado en Firestore")
            return anime
        }
        else {
            Log.d("ANIMEDB", "no encontrado en Firestore")
            anime = RetrofitInstance.animeApi.getAnime(animeId).data
            db.collection("Favoritos").document(animeId.toString()).set(anime)
            return anime
        }
    }

}