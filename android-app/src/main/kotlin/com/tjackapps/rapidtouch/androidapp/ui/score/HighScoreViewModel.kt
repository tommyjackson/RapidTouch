package com.tjackapps.rapidtouch.androidapp.ui.score

import androidx.lifecycle.ViewModel
import com.tjackapps.rapidtouch.models.Either
import com.tjackapps.rapidtouch.models.Score
import com.tjackapps.rapidtouch.repository.api.HighScoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HighScoreViewModel @Inject constructor(
    private val highScoreRepository: HighScoreRepository,
) : ViewModel() {

    suspend fun getHighScores(): List<Score> {
        return when (val response = highScoreRepository.getHighScores()) {
            is Either.Success -> {
                response.success
            }
            is Either.Failure -> {
                emptyList()
            }
        }
    }

    suspend fun clearHighScores() {
        highScoreRepository.clearHighScores()
    }
}