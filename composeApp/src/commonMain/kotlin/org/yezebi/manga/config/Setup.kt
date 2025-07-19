package org.yezebi.manga.config

fun init() {
    Environment.load()

    initHttpClient()
}
