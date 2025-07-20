package org.yezebi.manga.screen.manga

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
internal data class MangaScreenRoute(val id: String)

fun NavGraphBuilder.mangaScreen(onNavigateBack: () -> Unit) {
    composable<MangaScreenRoute>(
        enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(350)) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(350)) },
    ) { backStackEntry ->
        val route = backStackEntry.toRoute<MangaScreenRoute>()

        MangaScreen(route.id, onNavigateBack = onNavigateBack)
    }
}

fun NavController.navigateToManga(id: String) {
    navigate(MangaScreenRoute(id))
}
