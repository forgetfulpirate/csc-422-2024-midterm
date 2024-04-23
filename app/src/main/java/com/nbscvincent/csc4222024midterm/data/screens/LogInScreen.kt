package com.nbscvincent.csc4222024midterm.data.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.nbscvincent.csc4222024midterm.R

//import com.miguel.midterm.R

//import com.miguel.ktorapp.R
//import com.nbscvincent.csc4222024midterm.R
import com.nbscvincent.csc4222024midterm.data.viewmodel.user.UserViewModel

@Composable
fun LogInScreen(viewModel: UserViewModel) {

    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(100.dp)
                    .verticalScroll(scrollState),
                containerColor = Color.Black
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 0.dp, bottom = 0.dp)
                        .fillMaxSize()
                        .fillMaxWidth()
                        .background(Color.Black),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .absolutePadding(
                                left = 5.dp,
                                right = 5.dp,

                                )
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(
                            text = "LogIn",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White,
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Fishbook",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = Color.White
            )
            Text(
                text = "Welcome to Fishbook",
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(80.dp))
            
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Fitness Logo",
                modifier = Modifier.size(120.dp))
            
            MyOutlinedTextField()

        }

    }
}
@Composable
fun MyOutlinedTextField() {

    var passwordShow: Boolean by remember { mutableStateOf(false) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        label = { Text("Username") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

        trailingIcon = {
            Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "null", tint = Color.Red)
        },
        singleLine = true,

    )
//
//    Spacer(modifier = Modifier.height(5.dp))

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

        trailingIcon = {
            val image = if (passwordShow)
                Icons.Filled.Lock
            else
                Icons.Outlined.Lock

            val description = if (passwordShow) "Hide Password" else "Show Password"

            IconButton(onClick = {
                passwordShow = !passwordShow
            }) {
                Icon(imageVector = image, contentDescription =  description, tint = Color.Red)
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordShow) VisualTransformation.None else PasswordVisualTransformation(),


    )

}