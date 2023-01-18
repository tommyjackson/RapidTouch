package com.tjackapps.rapidtouch.androidapp.ui.game

import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    modifier: Modifier,
) {
    val scope = rememberCoroutineScope()
    val viewModel: GameViewModel = hiltViewModel()

    val buttonState = remember {
        mutableStateOf(true)
    }

    val scoreState = remember {
        mutableStateOf(0)
    }

    val textState = remember {
        mutableStateOf("Time remaining:")
    }

    val timer = object : CountDownTimer(20000, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            val secondsRemaining = (millisUntilFinished / 1000).toInt()
            textState.value = "Time remaining: $secondsRemaining"
        }

        override fun onFinish() {
            buttonState.value = false
            textState.value = "Game Over: ${scoreState.value}"
            scope.launch {
                viewModel.saveScore(scoreState.value)
                scoreState.value = 0
            }
        }
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
                verticalArrangement = Arrangement.Center,
                content = {
                    Text(
                        text = textState.value,
                        fontSize = 24.sp,
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        enabled = buttonState.value,
                        onClick = {
                            scoreState.value++
                        },
                        content = {
                            if (buttonState.value) {
                                Text(text = "Click Me")
                            } else {
                                Text(text = "Game Over")
                            }
                        },
                    )
                }
            )
        },
    )

    timer.start()
}

//@Preview
//@Composable
//private fun GameScreenPreview() {
//    AppTheme {
//        GameScreen(modifier = Modifier.fillMaxSize())
//    }
//}
