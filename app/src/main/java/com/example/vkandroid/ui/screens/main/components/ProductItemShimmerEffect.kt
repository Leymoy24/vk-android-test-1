package com.example.vkandroid.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkandroid.ui.theme.VKAndroidTheme
import com.example.vkandroid.utils.shimmerEffect

@Composable
fun ProductItemShimmerEffect() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.background)
            .border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.2f),
                shape = RoundedCornerShape(30.dp)
            )
            .shadow(elevation = 10.dp)
            .shimmerEffect(),
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Gray.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .shimmerEffect(),
                contentAlignment = Alignment.Center
            ) {

            }
            Column(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(30.dp)
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .shimmerEffect()
                )
                Box(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(30.dp)
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .shimmerEffect()
                )
                Box(modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(30.dp)
                    .padding(top = 10.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .shimmerEffect()
                )
            }
        }
    }
}

@Preview(widthDp = 200, heightDp = 350)
@Composable
private fun Preview() {
    VKAndroidTheme {
        ProductItemShimmerEffect()
    }
}