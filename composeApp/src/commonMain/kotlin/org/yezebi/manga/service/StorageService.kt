package org.yezebi.manga.service

interface StorageService {
    fun get(key: String): String?

    fun set(key: String, value: String)
}
