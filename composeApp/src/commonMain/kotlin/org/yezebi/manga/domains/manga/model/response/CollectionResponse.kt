package org.yezebi.manga.domains.manga.model.response

import kotlinx.serialization.Serializable
import org.yezebi.manga.domains.manga.model.MinimalVolume

@Serializable
data class CollectionResponse(
    val editions: List<EditionResponse>,
    val publishers: List<PublisherResponse>? = null,
    val series: List<SeriesResponse>,
    val volumes: List<VolumeResponse>,
) {
    fun minimalVolumes(): List<MinimalVolume> {
        val editionRecord = editionRecord()
        val seriesRecord = seriesRecord()

        return volumes.map {
            val edition = editionRecord[it.editionId]!!
            val series = seriesRecord[edition.seriesId]!!

            MinimalVolume.from(it, edition, series)
        }
    }

    fun editionRecord(): Map<String, EditionResponse> {
        return editions.associateBy { it.id }
    }

    fun seriesRecord(): Map<String, SeriesResponse> {
        return series.associateBy { it.id }
    }
}
