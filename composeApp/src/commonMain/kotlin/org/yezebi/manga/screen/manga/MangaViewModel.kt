package org.yezebi.manga.screen.manga

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.yezebi.manga.domains.manga.model.Volume
import org.yezebi.manga.domains.manga.services.MangaService

class MangaViewModel(
    private val mangaService: MangaService
): ViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _volume = MutableStateFlow<Volume?>(null)
    val volume = _volume.asStateFlow()

    fun init(id: String) {}
}
