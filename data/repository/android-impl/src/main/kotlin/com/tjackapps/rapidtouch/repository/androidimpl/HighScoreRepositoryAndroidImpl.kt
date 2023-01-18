package com.tjackapps.rapidtouch.repository.androidimpl

import com.tjackapps.rapidtouch.models.Either
import com.tjackapps.rapidtouch.models.Score
import com.tjackapps.rapidtouch.preferences.api.Preferences
import com.tjackapps.rapidtouch.repository.api.HighScoreRepository
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class HighScoreRepositoryAndroidImpl @Inject constructor(
    private val preferences: Preferences,
) : HighScoreRepository {

    override suspend fun insertHighScore(score: Score): Either<Unit, Exception> {
        return try {
            val highScores: MutableList<Score> = when (val response = getHighScores()) {
                is Either.Success -> {
                    response.success.toMutableList()
                }
                is Either.Failure -> {
                    mutableListOf()
                }
            }.apply {
                add(score)
            }

            val updatedHighScores = HighScores(
                items = highScores.sortedByDescending { it.score }
            )

            val highScoresJsonString = Json.encodeToString(updatedHighScores)
            preferences.putString(HIGH_SCORES_KEY, highScoresJsonString)

            Either.success(Unit)
        } catch (e: Exception) {
            Either.failure(e)
        }
    }

    override suspend fun getHighScores(): Either<List<Score>, Exception> {
        return try {
            val highScoresJsonString = preferences.getString(HIGH_SCORES_KEY)
            val highScores = Json.decodeFromString<HighScores>(highScoresJsonString)
            Either.success(highScores.items.sortedByDescending { it.score })
        } catch (e: Exception) {
            Either.failure(e)
        }
    }

    override suspend fun clearHighScores(): Either<Unit, Exception> {
        return try {
            preferences.putString(HIGH_SCORES_KEY, "")
            Either.success(Unit)
        } catch (e: Exception) {
            Either.failure(e)
        }
    }

    @Serializable
    private data class HighScores(
        val items: List<Score>,
    )

    companion object {
        private const val HIGH_SCORES_KEY = "high_scores"
    }
}
