package ar.edu.uade.c012025.animeapp.ui.screens.animelist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.AnimeRepository
import ar.edu.uade.c012025.animeapp.data.AnimeResult
import ar.edu.uade.c012025.animeapp.data.AnimeTestDataSource
import ar.edu.uade.c012025.animeapp.domain.IAnimeRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException

class AnimeListScreenViewModel(
    private val animeRepository: IAnimeRepository = AnimeRepository()
) : ViewModel()
{
    var uiState by mutableStateOf(AnimeListScreenState())
        private set

    init {
        getUserName()
    }

    private var fetchJob: Job? = null

    fun fetchAnimes() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState= uiState.copy(animeList = animeRepository.fetchAnimes(uiState.searchQuery), searchQuery = uiState.searchQuery, username = uiState.username)
            }
            catch (e: IOException) {
                Log.e("AnimeApp", "Error recuperando la lista de Anime")
            }
        }
    }

    fun searchChange(search: String) {
        uiState= uiState.copy(searchQuery = search, animeList = uiState.animeList, username = uiState.username)
    }

    fun getUserName() {
        uiState= uiState.copy(searchQuery = uiState.searchQuery, animeList = uiState.animeList, username = "${FirebaseAuth.getInstance().currentUser?.displayName ?: "Usuario Desconocido"} (${FirebaseAuth.getInstance().currentUser?.email ?: "email"})")
    }

}
