package com.vitalpro


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import vitalpro.composeapp.generated.resources.Res


@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color(0xFFFAEDCD))
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(Res.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
            )
            Row{
                Text(
                    "Vital",
                    Modifier,
                    Color(0xFF213B25),
                    fontSize = 75.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Pro",
                    Modifier,
                    Color(0xFFDC8B31),
                    fontSize = 75.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(onClick = { /* Handle click */ },Modifier) {
                Text("Comenzar!")
            }

        }
    }
}