package com.tjackapps.rapidtouch

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform