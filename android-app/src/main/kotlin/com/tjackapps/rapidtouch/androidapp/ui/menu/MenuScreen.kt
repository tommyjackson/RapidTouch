package com.tjackapps.rapidtouch.androidapp.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tjackapps.rapidtouch.androidapp.BuildConfig
import com.tjackapps.rapidtouch.androidapp.R
import com.tjackapps.rapidtouch.androidapp.component.PrimaryButton
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
                content = {

                    Spacer(modifier = Modifier.height(128.dp))

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        painter = painterResource(id = R.drawable.ic_app_banner),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )

                    Spacer(modifier = Modifier.height(96.dp))

                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onNavigate(Screen.Game)
                        },
                        text = "Play",
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onNavigate(Screen.Score)
                        },
                        text = "High Scores"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            onNavigate(Screen.Tutorial)
                        },
                        text = "How To Play",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(4.dp),
                        text = "Version ${BuildConfig.VERSION_NAME}",
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Center
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