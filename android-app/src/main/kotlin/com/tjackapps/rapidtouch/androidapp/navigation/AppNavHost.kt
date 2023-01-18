package com.tjackapps.rapidtouch.androidapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tjackapps.rapidtouch.androidapp.ui.game.GameScreen
import com.tjackapps.rapidtouch.androidapp.ui.menu.MenuScreen
import com.tjackapps.rapidtouch.androidapp.ui.score.HighScoreScreen
import com.tjackapps.rapidtouch.androidapp.ui.tutorial.TutorialScreen

@Composable
fun AppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: Screen,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
    ) {
        composable(
            route = Screen.Menu.route,
        ) {
            MenuScreen(
                modifier = modifier.fillMaxSize(),
                onNavigate = {
                    navController.navigate(it.route)
                }
            )
        }

        composable(
            route = Screen.Game.route,
        ) {
            GameScreen(
                modifier = modifier.fillMaxSize(),
            )
        }

        composable(
            route = Screen.Score.route,
        ) {
            HighScoreScreen(
                modifier = modifier.fillMaxSize(),
            )
        }

        composable(
            route = Screen.Tutorial.route,
        ) {
            TutorialScreen(
                modifier = modifier.fillMaxSize(),
            )
        }
    }
}