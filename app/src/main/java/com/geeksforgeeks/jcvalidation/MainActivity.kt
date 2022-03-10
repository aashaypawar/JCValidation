package com.geeksforgeeks.jcvalidation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("GFG | Validation", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){

    val mContext = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        val mUsername = remember { mutableStateOf("") }
        val mPassword = remember { mutableStateOf("") }

        OutlinedTextField(
            value = mUsername.value,
            onValueChange = { mUsername.value = it },
            label = { Text(text = "Username") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = mPassword.value,
            onValueChange = { mPassword.value = it },
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            if(mUsername.value.isEmpty() and mPassword.value.isNotEmpty()){
                Toast.makeText(mContext, "Username is Empty", Toast.LENGTH_SHORT).show()
            }
            if (mPassword.value.isEmpty() and mUsername.value.isNotEmpty()){
                Toast.makeText(mContext, "Password is Empty", Toast.LENGTH_SHORT).show()
            }
            if(mUsername.value.isEmpty() and mPassword.value.isEmpty()){
                Toast.makeText(mContext, "Username and Password are Empty", Toast.LENGTH_SHORT).show()
            }
            if(mUsername.value.isNotEmpty() and mPassword.value.isNotEmpty()){
                Toast.makeText(mContext, "Successfully Validated", Toast.LENGTH_SHORT).show()
            }
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)),
        ) {
            Text("Next", color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}