package com.example.compose_turtorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose_turtorial.ui.theme.Compose_turtorialTheme

class BasicLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_turtorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {}
            }
        }
    }
}

@Composable
fun LayoutHomeScreen() {
    Box {
        Column(
            modifier = Modifier
                .size(300.dp, 500.dp)
                .background(color = Color.Black)
                .verticalScroll(rememberScrollState()),
        ) {
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
fun ExOutlineTextField() {
    Box {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.weight(2f))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun RowExamples() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(400.dp, 300.dp)
            .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BoxItem(color = Color.Blue)
        BoxItem(color = Color.Red)
        BoxItem(color = Color.Yellow)
        BoxItem(color = Color.Black)
        BoxItem(color = Color.Green)
    }
}


@Composable
fun BoxExamples() {
    BoxItem(color = Color.Blue)
    BoxItem(color = Color.Red)
    BoxItem(color = Color.Yellow)
    BoxItem(color = Color.Black)
    BoxItem(color = Color.Green)
}

@Composable
fun BoxItem(modifier: Modifier = Modifier, color: Color, size: Dp = 100.dp) {
    Box(
        modifier = modifier
            .size(size)
            .background(color = color)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Compose_turtorialTheme {
        LayoutHomeScreen()
    }
}