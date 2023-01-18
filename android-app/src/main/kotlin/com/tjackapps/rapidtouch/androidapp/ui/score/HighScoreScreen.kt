package com.tjackapps.rapidtouch.androidapp.ui.score

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tjackapps.rapidtouch.androidapp.design.AppTheme
import com.tjackapps.rapidtouch.models.Score
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HighScoreScreen(
    modifier: Modifier,
) {
    val scope = rememberCoroutineScope()
    val viewModel: HighScoreViewModel = hiltViewModel()

    val highScores: MutableState<List<Score>> = remember {
        mutableStateOf(emptyList())
    }

    LaunchedEffect(Unit) {
        highScores.value = viewModel.getHighScores()
    }

    Scaffold(
        modifier = modifier,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                content = {
                    Spacer(modifier = Modifier.height(48.dp))

                    Text(
                        text = "High Scores",
                        fontSize = 24.sp,
                    )

                    LazyColumn(
                        content = {
                            items(highScores.value) { score ->
                                Text(text = "${score.name} - ${score.score}")
                            }
                        },
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            scope.launch {
                                viewModel.clearHighScores()
                            }
                        },
                        content = {
                            Text(text = "Reset Scores")
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
        HighScoreScreen(modifier = Modifier.fillMaxSize())
    }
}
