package org.yezebi.manga.domains.manga.services.impl

import io.ktor.client.call.*
import io.ktor.client.request.*
import org.yezebi.manga.config.httpClient
import org.yezebi.manga.domains.manga.model.Volume
import org.yezebi.manga.domains.manga.model.response.CollectionResponse
import org.yezebi.manga.domains.manga.services.MangaService

class MangaServiceImpl : MangaService {
    override suspend fun getNews(): List<Volume> {
        val response = httpClient.get("v2/volumes/news").body<CollectionResponse>()

        return response.toVolumes()
    }

    override suspend fun getById(id: String): Volume {
        val response = httpClient.get("v2/volumes/$id").body<CollectionResponse>()

        val volume = response.volumes.find { it.id == id }!!
        val edition = response.editionRecord()[volume.editionId]!!
        val series = response.seriesRecord()[edition.seriesId]!!

        return Volume.from(volume, edition, series)
    }
}
