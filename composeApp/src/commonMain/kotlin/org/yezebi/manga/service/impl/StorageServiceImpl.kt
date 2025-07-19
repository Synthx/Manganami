package org.yezebi.manga.service.impl

import com.russhwolf.settings.Settings
import org.yezebi.manga.service.StorageService

class StorageServiceImpl : StorageService {
    private val settings = Settings()

    override fun set(key: String, value: String) {
        settings.putString(key, value)
    }

    override fun get(key: String): String? {
        return settings.getStringOrNull(key)
    }
}
