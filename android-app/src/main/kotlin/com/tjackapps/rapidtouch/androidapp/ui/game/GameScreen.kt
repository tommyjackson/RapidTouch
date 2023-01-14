package com.tjackapps.rapidtouch.androidapp.ui.game

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tjackapps.rapidtouch.androidapp.design.AppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    modifier: Modifier,
) {
    val scope = rememberCoroutineScope()
    val viewModel: GameViewModel = hiltViewModel()

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
                        text = "Begin!",
                        fontSize = 24.sp,
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            scope.launch {
                                viewModel.onButtonClicked()
                            }
                        },
                        content = {
                            Text(text = "Click Me")
                        },
                    )
                }
            )
        },
    )
}

//@Preview
//@Composable
//private fun GameScreenPreview() {
//    AppTheme {
//        GameScreen(modifier = Modifier.fillMaxSize())
//    }
//}
