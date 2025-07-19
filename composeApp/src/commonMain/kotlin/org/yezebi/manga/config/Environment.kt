package org.yezebi.manga.config

import org.yezebi.manga.config.environment.LocalEnvironment
import org.yezebi.manga.model.EnvironmentValue

object Environment {
    lateinit var value: EnvironmentValue

    fun load(env: String = "local") {
        when (env) {
            "local" -> {
                value = LocalEnvironment()
            }

            else -> {
                throw IllegalStateException("Unknown environment: $env")
            }
        }
    }
}
