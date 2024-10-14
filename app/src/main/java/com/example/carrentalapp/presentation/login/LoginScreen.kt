package com.example.carrentalapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.example.carrentalapp.R
//
@Composable
fun LoginScreen(navController: NavController,) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Top,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp)
//        ) {
//            // Logo at the top
//            Image(
//                painter = painterResource(id = R.drawable.), // Replace with your logo resource
//                contentDescription = "App Logo",
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(top = 48.dp, bottom = 32.dp)
//            )
//
//            // Email TextField
//            CustomTextField(
//                label = "Email",
//                value = viewModel.email,
//                onValueChange = { viewModel.email = it }
//            )
//
//            // Password TextField with hide/unhide toggle
//            CustomTextField(
//                label = "Password",
//                value = viewModel.password,
//                onValueChange = { viewModel.password = it },
//                isPassword = true,
//                isPasswordVisible = viewModel.isPasswordVisible,
//                onPasswordToggleClick = { viewModel.isPasswordVisible = !viewModel.isPasswordVisible }
//            )
//
//            // Forgot Password on the left side
//            Row(
//                horizontalArrangement = Arrangement.Start,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                TextButton(onClick = { viewModel.forgotPassword() }) {
//                    Text(text = "Forgot Password?")
//                }
//            }
//
//            // Custom Login Button
//            Button(
//                onClick = { viewModel.login() },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 16.dp)
//            ) {
//                Text(text = "Login")
//            }
//
//            // Sign-up Button
//            TextButton(onClick = { /* Navigate to Sign-up Screen */ }) {
//                Text(text = "Don't have an account? Sign Up")
//            }
//
//            // Divider for social sign-in options
//            Spacer(modifier = Modifier.height(16.dp))
//            Divider()
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Sign in with Google Button
//            Button(
//                onClick = { viewModel.signInWithGoogle() },
//                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors(  Color.Red)
//            ) {
//                Text(text = "Sign in with Google")
//            }
//
//            // Sign in with Facebook Button
//            Button(
//                onClick = { viewModel.signInWithFacebook() },
//                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors( Color.Blue)
//            ) {
//                Text(text = "Sign in with Facebook")
//            }
//
//            // Sign in with Apple Button
//            Button(
//                onClick = { viewModel.signInWithApple() },
//                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors( Color.Black)
//            ) {
//                Text(text = "Sign in with Apple", color = Color.White)
//            }
//        }
//    }
}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomTextField(
//    label: String,
//    value: String,
//    onValueChange: (String) -> Unit,
//    isPassword: Boolean = false,
//    isPasswordVisible: Boolean = false,
//    onPasswordToggleClick: () -> Unit = {}
//) {
//
//    var password by remember { mutableStateOf(value = "") }
//    var showPassword by remember { mutableStateOf(value = false) }
//    var isRemembered by remember { mutableStateOf(false) }
//    var NEWTextValue by remember {
//        mutableStateOf("")
//    }
//    val myColor = Color(0xFF0ED500)
//    val myColor2 = Color(0xFF1919BF)
//    val myColor3 = Color(0xFFEDEDEE)
//    val myColor4 = Color(0xFF60778C)
////    TextField(
////        value = value,
////        onValueChange = onValueChange,
////        label = { Text(label) },
////        trailingIcon = {
////            if (isPassword) {
////                IconButton(onClick = onPasswordToggleClick) {
////                    Icon(
////                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
////                        contentDescription = if (isPasswordVisible) "Hide password" else "Show password"
////                    )
////                }
////            }
////        },
////        visualTransformation = if (isPassword && !isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
////        singleLine = true,
////        modifier = Modifier
////            .fillMaxWidth()
////            .padding(vertical = 8.dp)
////    )
//    TextField(
//        modifier = Modifier
//            .fillMaxWidth(),
//        value = password,
//        onValueChange = { newText ->
//            password = newText
//        },
//        label = {
//            Text(text = "Password")
//        },
//        placeholder = { Text(text = "Type password here") },
//        shape = RoundedCornerShape(percent = 20),
//        visualTransformation = if (showPassword) {
//
//            VisualTransformation.None
//
//        } else {
//
//            PasswordVisualTransformation()
//
//        },
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        trailingIcon = {
//            if (showPassword) {
//                IconButton(onClick = { showPassword = false }) {
//                    Icon(
//                        imageVector = Icons.Filled.Visibility,
//                        contentDescription = "hide_password"
//                    )
//                }
//            } else {
//                IconButton(
//                    onClick = { showPassword = true }) {
//                    Icon(
//                        imageVector = Icons.Filled.VisibilityOff,
//                        contentDescription = "hide_password"
//                    )
//                }
//            }
//        },
//        colors = TextFieldDefaults.textFieldColors(
//
//            focusedLabelColor = myColor4,
//            cursorColor = myColor4,
//            focusedTextColor = myColor4,
//            focusedLeadingIconColor = myColor4,
//            unfocusedLeadingIconColor = myColor4,
//            focusedTrailingIconColor = myColor4,
//            unfocusedTrailingIconColor = myColor4,
//            unfocusedIndicatorColor = Color.Transparent,
//            focusedIndicatorColor = Color.Transparent,
//
////                    containerColor = myColor2
//            containerColor = myColor3,
//
//            )
//    )
//}