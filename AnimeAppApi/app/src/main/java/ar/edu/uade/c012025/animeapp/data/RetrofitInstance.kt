package ar.edu.uade.c012025.animeapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BASE_URL = "https://api.jikan.moe/v4/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val animeApi: IAnimeAPI by lazy {
        retrofit.create(IAnimeAPI::class.java)
    }

}