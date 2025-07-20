package org.yezebi.manga.domains.manga.model

import org.yezebi.manga.domains.manga.model.response.EditionResponse
import org.yezebi.manga.domains.manga.model.response.SeriesResponse
import org.yezebi.manga.domains.manga.model.response.VolumeResponse

data class MinimalVolume(
    val id: String,
    val title: String,
    val number: Long,
    val imageUrl: String?,
) {
    companion object {
        fun from(volume: VolumeResponse, edition: EditionResponse, series: SeriesResponse): MinimalVolume {
            val title = arrayOf(series.title, edition.title).filterNotNull().joinToString(" - ")

            return MinimalVolume(
                id = volume.id,
                title = title,
                number = volume.number,
                imageUrl = volume.imageUrl
            )
        }
    }
}
