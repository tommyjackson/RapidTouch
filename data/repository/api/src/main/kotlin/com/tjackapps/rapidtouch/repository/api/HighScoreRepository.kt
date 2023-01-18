package com.tjackapps.rapidtouch.repository.api

import com.tjackapps.rapidtouch.models.Either
import com.tjackapps.rapidtouch.models.Score

interface HighScoreRepository {
    suspend fun insertHighScore(score: Score): Either<Unit, Exception>
    suspend fun getHighScores(): Either<List<Score>, Exception>
    suspend fun clearHighScores(): Either<Unit, Exception>
}