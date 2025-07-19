package org.yezebi.manga.domains.auth.model.response

import kotlinx.datetime.Clock
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val TOKEN_EXPIRATION_BUFFER_SECONDS = 30

@Serializable
data class TokenResponse(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("created_at")
    val createdAt: Long,
    @SerialName("expires_in")
    val expiresIn: Long
) {
    fun isExpired(): Boolean {
        val now = Clock.System.now().epochSeconds

        return now >= (createdAt + expiresIn - TOKEN_EXPIRATION_BUFFER_SECONDS)
    }
}
