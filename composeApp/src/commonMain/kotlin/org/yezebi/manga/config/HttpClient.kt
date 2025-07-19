package org.yezebi.manga.config

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.yezebi.manga.domains.auth.service.AuthTokenService
import org.yezebi.manga.service.impl.StorageServiceImpl

lateinit var httpClient: HttpClient

private val baseHttpClient = HttpClient {
    defaultRequest {
        url(Environment.value.apiUrl)
    }

    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.INFO
    }
}

fun initHttpClient() {
    val authTokenService = AuthTokenService(
        baseHttpClient,
        StorageServiceImpl()
    )

    httpClient = baseHttpClient.config {
        install(Auth) {
            bearer {
                loadTokens {
                    val token = authTokenService.getToken()

                    BearerTokens(token, null)
                }
            }
        }
    }
}
