package org.yezebi.manga.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.yezebi.manga.domains.manga.model.Volume
import org.yezebi.manga.domains.manga.services.MangaService

class MainViewModel(
    private val mangaService: MangaService
) : ViewModel() {
    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _volumes = MutableStateFlow<List<Volume>>(emptyList())
    val volumes = _volumes.asStateFlow()

    fun init() {
        viewModelScope.launch {
            _loading.value = true

            try {
                val volumes = mangaService.getNews()

                _volumes.value = volumes
            } catch (e: Exception) {
                println(e)
            } finally {
                _loading.value = false
            }
        }
    }
}
