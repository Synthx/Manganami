package org.yezebi.manga.screen.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
internal object MainScreenRoute

fun NavGraphBuilder.mainScreen(onNavigateToMangaScreen: (String) -> Unit) {
    composable<MainScreenRoute> {
        MainScreen(onNavigateToMangaScreen = onNavigateToMangaScreen)
    }
}
