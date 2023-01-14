package com.tjackapps.rapidtouch.androidapp.ui.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tjackapps.rapidtouch.androidapp.design.AppTheme
import com.tjackapps.rapidtouch.androidapp.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    modifier: Modifier,
    onNavigate: (Screen) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                content = {
                    Text(
                        text = "Rapid Touch",
                        fontSize = 24.sp,
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onNavigate(Screen.Game)
                        },
                        content = {
                            Text(text = "Play")
                        },
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onNavigate(Screen.Score)
                        },
                        content = {
                            Text(text = "High Scores")
                        },
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onNavigate(Screen.Tutorial)
                        },
                        content = {
                            Text(text = "How To Play")
                        },
                    )
                }
            )
        },
    )
}

@Preview
@Composable
private fun MenuScreenPreview() {
    AppTheme {
        MenuScreen(
            modifier = Modifier.fillMaxSize(),
            onNavigate = {},
        )
    }
}