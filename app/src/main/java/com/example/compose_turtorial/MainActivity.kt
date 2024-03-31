package com.example.compose_turtorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_turtorial.ui.theme.Compose_turtorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_turtorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(24.dp)) {
        GreetingText()
        Spacer(modifier = Modifier.height(12.dp))
        MultipleStyleText()
    }
}

@Composable
fun GreetingText() {
    Text(
        text = stringResource(id = R.string.app_name),
        color = Color.Red,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Justify,
        fontFamily = FontFamily.Cursive,
        textDecoration = TextDecoration.LineThrough,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
//        // Dung khi dinh nghia type cho 1 text
//        style = TextStyle(
//            color = Color.Black
//        )


    )
}

@Composable
fun MultipleStyleText() {
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("H")
        }
        withStyle(style = SpanStyle(color = Color ))
        append("ello")

        withStyle(style = SpanStyle(color = Color.Green)) {
            append("t")
        }
        append("urtorial")
    })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_turtorialTheme {
        HomeScreen()
    }
}