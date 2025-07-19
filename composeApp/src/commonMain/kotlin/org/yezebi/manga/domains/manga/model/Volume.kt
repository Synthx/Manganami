package org.yezebi.manga.domains.manga.model

import kotlinx.datetime.LocalDate
import org.yezebi.manga.domains.manga.model.response.EditionResponse
import org.yezebi.manga.domains.manga.model.response.SeriesResponse
import org.yezebi.manga.domains.manga.model.response.VolumeResponse

data class Volume(
    val id: String,
    val title: String,
    val number: Long,
    val releaseDate: LocalDate,
    val imageUrl: String?,
) {
    companion object {
        fun from(volume: VolumeResponse, edition: EditionResponse, series: SeriesResponse): Volume {
            val title = arrayOf(series.title, edition.title).filterNotNull().joinToString(" - ")

            return Volume(
                id = volume.id,
                title = title,
                number = volume.number,
                releaseDate = volume.releaseDate,
                imageUrl = volume.imageUrl
            )
        }
    }
}
