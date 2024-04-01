package com.example.compose_turtorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_turtorial.ui.theme.Compose_turtorialTheme

class Button_4 : ComponentActivity() {
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
fun ButtonHomeScreen() {
    Column(modifier = Modifier.padding(24.dp)) {
        SimpleButton()
        CommonSpace()
        DemoClickable()
//        RoundedButton()
//        CommonSpace()
//        BorderedSimpleButton()
//        CommonSpace()
//        ElevationSimpleButton()
//        OutlinedButton(onClick = {}) {
//            Text(text = "Outlined Button")
//        }
//        TextButton(onClick = { /*TODO*/ }) {
//            Text(text = "Text Button")
//        }
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Default.Phone,
//                contentDescription = null
//            )
//        }
    }
}

@Composable
fun SimpleButton() {
    val count = remember {
        mutableStateOf(0)
    }

    Column() {
        Text(text = "click icon ${count.value}")
        Button(
            onClick = {
                count.value++
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Black,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Blue
            )
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart, contentDescription = null
            )
            Text(text = "Click me")
        }
    }
}

@Composable
fun DemoClickable() {
//    Text(text = "Click Text", modifer= Modifier.clickable {
//
//    })
//
//    Column (modifier = Modifier.width(100.dp)) {
//
//    }
}

@Composable
fun RoundedButton() {
    Button(
        onClick = { /*TODO*/ }, shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
    ) {
        Text(text = "Rounded Button")
    }
}

@Composable
fun BorderedSimpleButton() {
    Button(
        onClick = {},
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Checkout", color = Color.Magenta)
    }
}

@Composable
fun ElevationSimpleButton() {
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )) {
        Text(text = "Elevation Button")
    }
}

@Composable
fun CommonSpace() {
    Spacer(modifier = Modifier.height(24.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Compose_turtorialTheme {
        ButtonHomeScreen()
    }
}