package com.tjackapps.rapidtouch.androidapp.navigation

sealed class Screen(val route: String) {
    object Menu : Screen("/menu")
    object Game : Screen("/game")
    object Score : Screen("/score")
    object Tutorial : Screen("/tutorial")
}