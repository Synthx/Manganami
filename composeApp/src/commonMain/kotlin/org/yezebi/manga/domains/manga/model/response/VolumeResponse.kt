package org.yezebi.manga.domains.manga.model.response

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeResponse(
    val id: String,
    val number: Long,
    @SerialName("release_date")
    val releaseDate: LocalDate,
    @SerialName("edition_id")
    val editionId: String,
    val isbn: String?,
    val asin: String?,
    val title: String?,
    @SerialName("image_url")
    val imageUrl: String?,
)