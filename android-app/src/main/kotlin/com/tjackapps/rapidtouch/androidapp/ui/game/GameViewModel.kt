package com.tjackapps.rapidtouch.androidapp.ui.game

import androidx.lifecycle.ViewModel
import com.tjackapps.rapidtouch.preferences.api.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val preferences: Preferences,
) : ViewModel() {

    suspend fun onButtonClicked() {
        val num = preferences.getInt(CLICKS_KEY)
        preferences.putInt(CLICKS_KEY, num + 1)
    }

    companion object {
        private const val CLICKS_KEY = "clicks_key"
    }
}