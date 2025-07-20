package org.yezebi.manga.domains.manga.services

import org.yezebi.manga.domains.manga.model.MinimalVolume
import org.yezebi.manga.domains.manga.model.Volume

interface MangaService {
    suspend fun getNews(): List<MinimalVolume>

    suspend fun getById(id: String): Volume
}