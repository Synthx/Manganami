package org.yezebi.manga.domains.manga.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PublisherResponse(
    val id: String,
    val title: String,
    val closed: Boolean
)
