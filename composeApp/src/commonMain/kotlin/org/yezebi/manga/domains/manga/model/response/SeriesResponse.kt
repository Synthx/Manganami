package org.yezebi.manga.domains.manga.model.response

import kotlinx.serialization.Serializable

@Serializable
data class SeriesResponse(
    val id: String,
    val title: String
)
