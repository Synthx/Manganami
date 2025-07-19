package org.yezebi.manga.domains.auth.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import org.yezebi.manga.config.Environment
import org.yezebi.manga.domains.auth.model.request.CreateTokenRequest
import org.yezebi.manga.domains.auth.model.response.TokenResponse
import org.yezebi.manga.service.StorageService

private const val AUTH_TOKEN_KEY = "auth_token"

class AuthTokenService(
    private val httpClient: HttpClient,
    private val storageService: StorageService,
) {
    private var token: TokenResponse? = null

    suspend fun getToken(): String {
        if (token == null) {
            val storedTokenStr = storageService.get(AUTH_TOKEN_KEY)
            if (storedTokenStr != null) {
                val storedToken = Json.decodeFromString<TokenResponse>(storedTokenStr)
                if (!storedToken.isExpired()) {
                    token = storedToken

                    return storedToken.accessToken
                }
            }

            val request = CreateTokenRequest(
                Environment.value.authClientId,
                Environment.value.authClientSecret,
                "client_credentials"
            )

            val newToken = httpClient.post("oauth/token") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }.body<TokenResponse>()

            storageService.set(AUTH_TOKEN_KEY, Json.encodeToString(newToken))

            token = newToken
        }

        return token!!.accessToken
    }
}
