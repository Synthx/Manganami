package org.yezebi.manga.screen.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.yezebi.manga.domains.manga.model.Volume
import org.yezebi.manga.domains.manga.services.MangaService
import org.yezebi.manga.model.MutableLazyStateFlow

class MangaViewModel(
    private val mangaService: MangaService
): ViewModel() {
    private val _volume = MutableLazyStateFlow<Volume?>(null)
    val volume = _volume.asStateFlow()

    fun init(id: String) {
        viewModelScope.launch {
            _volume.value = _volume.value.copy(isLoading = true)

            try {
                val volume = mangaService.getById(id)

                _volume.value = _volume.value.copy(data = volume)
            } catch (e: Exception) {
                _volume.value = _volume.value.copy(error = e)
            } finally {
                _volume.value = _volume.value.copy(isLoading = false)
            }
        }
    }
}
