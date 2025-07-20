package org.yezebi.manga.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.yezebi.manga.domains.manga.model.MinimalVolume
import org.yezebi.manga.domains.manga.services.MangaService
import org.yezebi.manga.model.MutableLazyStateFlow

class MainViewModel(
    private val mangaService: MangaService
) : ViewModel() {
    private val _volumes = MutableLazyStateFlow<List<MinimalVolume>>(emptyList())
    val volumes = _volumes.asStateFlow()

    fun init() {
        viewModelScope.launch {
            _volumes.value = _volumes.value.copy(isLoading = true)

            try {
                val volumes = mangaService.getNews()

                _volumes.value = _volumes.value.copy(data = volumes)
            } catch (e: Exception) {
                _volumes.value = _volumes.value.copy(error = e)
            } finally {
                _volumes.value = _volumes.value.copy(isLoading = false)
            }
        }
    }
}
