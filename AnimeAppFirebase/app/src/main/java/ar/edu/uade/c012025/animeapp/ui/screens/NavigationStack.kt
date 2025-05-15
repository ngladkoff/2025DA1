package ar.edu.uade.c012025.animeapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.uade.c012025.animeapp.ui.screens.animedetail.AnimeDetailScreen
import ar.edu.uade.c012025.animeapp.ui.screens.animelist.AnimeListScreen
import ar.edu.uade.c012025.animeapp.ui.screens.login.LoginScreen
import ar.edu.uade.c012025.animeapp.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack(
    onGoogleLoginClick: () -> Unit,
    navController: NavHostController,
    onLogoutClick: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    )  {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(onGoogleLoginClick, navController = navController)
        }
        composable(route = Screens.AnimeList.route) {
            AnimeListScreen(navController = navController, onLogoutClick = onLogoutClick)
        }
        composable(route = Screens.AnimeDetail.route + "/{animeId}") { it ->
            var id = it.arguments?.getString("animeId")
            val animeId = id?.toIntOrNull()
            AnimeDetailScreen(animeId ?: 0)
        }

    }

}