package org.yezebi.manga.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.koinInject
import org.yezebi.manga.domains.manga.component.VolumeCard
import org.yezebi.manga.domains.manga.services.MangaService

@Composable
fun MainScreen(
    onNavigateToMangaScreen: (String) -> Unit,
    mangaService: MangaService = koinInject(),
    mainViewModel: MainViewModel = viewModel { MainViewModel(mangaService) }
) {
    val volumes by mainViewModel.volumes.collectAsState()

    LaunchedEffect(true) {
        mainViewModel.init()
    }

    Scaffold {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp),
        ) {
            items(volumes) {
                VolumeCard(it, onClick = onNavigateToMangaScreen)
            }
        }
    }
}
