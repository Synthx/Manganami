package org.yezebi.manga

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinApplication
import org.yezebi.manga.config.appModule
import org.yezebi.manga.config.theme.CustomTheme
import org.yezebi.manga.model.Screen
import org.yezebi.manga.screen.main.MainScreen

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    KoinApplication(application = {
        modules(appModule)
    }) {
        CustomTheme {
            Scaffold {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.name,
                ) {
                    composable(route = Screen.Home.name) {
                        MainScreen()
                    }
                }
            }
        }
    }
}
