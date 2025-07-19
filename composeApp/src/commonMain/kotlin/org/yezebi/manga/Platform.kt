package org.yezebi.manga

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform