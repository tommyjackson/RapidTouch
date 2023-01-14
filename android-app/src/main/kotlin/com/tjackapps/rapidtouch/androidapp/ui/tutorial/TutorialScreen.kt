package com.tjackapps.rapidtouch.androidapp.ui.tutorial

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TutorialScreen(
    modifier: Modifier,
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
                verticalArrangement = Arrangement.SpaceBetween,
                content = {
                    Spacer(modifier = Modifier.height(48.dp))

                    Text(
                        text = "How To Play",
                        fontSize = 24.sp,
                    )

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {

                        },
                        content = {
                            Text(text = "Let's play!")
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
        TutorialScreen(modifier = Modifier.fillMaxSize())
    }
}
