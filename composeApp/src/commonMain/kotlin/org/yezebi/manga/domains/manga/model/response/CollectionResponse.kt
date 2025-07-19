package org.yezebi.manga.domains.manga.model.response

import kotlinx.serialization.Serializable
import org.yezebi.manga.domains.manga.model.Volume

@Serializable
data class CollectionResponse(
    val editions: List<EditionResponse>,
    val series: List<SeriesResponse>,
    val volumes: List<VolumeResponse>,
) {
    fun toVolumes(): List<Volume> {
        val editionsRecord = editions.associateBy { it.id }
        val seriesRecord = series.associateBy { it.id }

        return volumes.map {
            val edition = editionsRecord[it.editionId]!!
            val series = seriesRecord[edition.seriesId]!!

            Volume.from(it, edition, series)
        }
    }
}
