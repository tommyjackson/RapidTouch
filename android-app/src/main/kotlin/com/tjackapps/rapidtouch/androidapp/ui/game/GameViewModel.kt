package com.tjackapps.rapidtouch.androidapp.ui.game

import androidx.lifecycle.ViewModel
import com.tjackapps.rapidtouch.models.Score
import com.tjackapps.rapidtouch.repository.api.HighScoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val highScoreRepository: HighScoreRepository,
) : ViewModel() {

    suspend fun saveScore(score: Int) {
        highScoreRepository.insertHighScore(
            score = Score(
                id = UUID.randomUUID().toString(),
                name = "Tjack",
                score = score,
            )
        )
    }
}