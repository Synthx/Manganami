package org.yezebi.manga

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinApplication
import org.yezebi.manga.config.appModule
import org.yezebi.manga.config.theme.CustomTheme
import org.yezebi.manga.screen.main.MainScreenRoute
import org.yezebi.manga.screen.main.mainScreen
import org.yezebi.manga.screen.manga.mangaScreen
import org.yezebi.manga.screen.manga.navigateToManga

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    KoinApplication(application = {
        modules(appModule)
    }) {
        CustomTheme {
            Scaffold { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = MainScreenRoute,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    mainScreen(onNavigateToMangaScreen = { id -> navController.navigateToManga(id) })
                    mangaScreen(onNavigateBack = {
                        navController.popBackStack()
                    })
                }
            }
        }
    }
}
