package org.yezebi.manga.domains.manga.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EditionResponse(
    val id: String,
    @SerialName("not_finished")
    val notFinished: Boolean,
    @SerialName("commercial_stop")
    val commercialStop: Boolean,
    @SerialName("publisher_id")
    val publisherId: String,
    @SerialName("series_id")
    val seriesId: String,
    @SerialName("volumes_count")
    val volumesCount: Long,
    val title: String?
)
