package com.example.compose_turtorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.example.compose_turtorial.ui.theme.Compose_turtorialTheme

class ManageState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_turtorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Composable
//State full
fun LoginScreen() {
    val loginViewModel: LoginViewModel = LoginViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.e("frank", "Login screen start")
        Welcome()


        Email(loginViewModel.email.value) {
            loginViewModel.updateEmail(it)
        }
        Log.e("frank", "Login screen end")


//        PassWord(password = password) {
//            password = it
//        }


        Button(onClick = {

        }) {
            Text(text = "Login")
        }
    }
}

class LoginViewModel: ViewModel() {
    //      Khi de trong Email() neu thang khac muon truy cap vao, khong dieu khien duoc
    var _email = mutableStateOf("")
    val email : State<String>
    get() = _email

    var password = mutableStateOf("")


    fun updateEmail(newEmail: String){
        _email.value = newEmail
    }

}



// State less -- Do day state ra ngoai cho loginscreen giu
@Composable
fun Email(email: String, onEmailChange: (String) -> Unit) {
    Log.e("frank", "Email")
    OutlinedTextField(value = email, onValueChange = onEmailChange)
}

@Composable
fun PassWord(password: String, onPassWordChange: (String) -> Unit) {
    Log.e("frank", "Password")
    OutlinedTextField(value = password, onValueChange = onPassWordChange)
}

// State less
@Composable
fun Welcome() {
    Log.e("frank", "Welcome Start")
    Text(text = "Login to your account")
    Log.e("frank", "Welcome end")
}

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by rememberSaveable {
            mutableStateOf("")
        }
        Email(email) {
            email = it
        }
    }
}

sealed class LoginScreenState {
    class Loading: LoginScreenState()
    class Success(): LoginScreenState()
    class Fall(): LoginScreenState()

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    Compose_turtorialTheme {
        LoginScreen()
    }
}