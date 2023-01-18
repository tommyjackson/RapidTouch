package com.tjackapps.rapidtouch.models

import kotlinx.serialization.Serializable

@Serializable
data class Score(
    val id: String,
    val name: String,
    val score: Int,
)
