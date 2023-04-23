package com.tjackapps.rapidtouch.androidapp.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.height(48.dp),
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        content = {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                fontSize = 18.sp,
            )
        }
    )
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    PrimaryButton(text = "Play", onClick = {})
}