package org.yezebi.manga.screen.manga

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import manga.composeapp.generated.resources.Res
import manga.composeapp.generated.resources.arrow_left
import manga.composeapp.generated.resources.back_button
import manga.composeapp.generated.resources.volume_number
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.koin.compose.koinInject
import org.yezebi.manga.component.SingleLineText
import org.yezebi.manga.domains.manga.services.MangaService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MangaScreen(
    id: String,
    onNavigateBack: () -> Unit,
    mangaService: MangaService = koinInject(),
    mangaViewModel: MangaViewModel = viewModel { MangaViewModel(mangaService) }
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val volume by mangaViewModel.volume.collectAsState()

    LaunchedEffect(true) {
        mangaViewModel.init(id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                ),
                navigationIcon = {
                    FilledIconButton(
                        onClick = onNavigateBack,
                        shape = RoundedCornerShape(4.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                        ),
                    ) {
                        Icon(
                            imageVector = vectorResource(Res.drawable.arrow_left),
                            contentDescription = stringResource(Res.string.back_button),
                            modifier = Modifier.size(20.dp),
                        )
                    }
                },
                title = {
                    volume.data?.let {
                        Column {
                            SingleLineText(
                                it.title,
                                style = MaterialTheme.typography.bodySmall,
                            )
                            SingleLineText(
                                stringResource(Res.string.volume_number, it.number),
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection).padding(innerPadding)
        ) {
            Text("Screen content")
        }
    }
}
