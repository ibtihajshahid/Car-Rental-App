package com.example.carrentalapp.presentation.navigation.Nested

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrentalapp.presentation.login.LoginScreen
//import com.example.carrentalapp.presentation.login.LoginScreen
import com.example.carrentalapp.presentation.navigation.Routes.Routes


import com.example.carrentalapp.presentation.ui.Screen.OnboardingScreen

import com.example.carrentalapp.presentation.ui.Screen.SplashScreen


@Composable
fun NestedDetailScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.SplashScreen
        ) {

            composable(Routes.SplashScreen) {
                SplashScreen(navController = navController)
            } 
            composable(Routes.OnboardingScreen) {
                OnboardingScreen(navController = navController)
            }
            composable(Routes.LoginScreen) {
               LoginScreen(navController = navController)
            }
//            composable(Routes.HomeScreen) {
//                HomeScreen(navController = navController)
//            }
//            composable(Routes.SettingsScreen) {
//                SettingsScreen()
//            }
//            composable(Routes.DetailScreen) {
//                DetailScreen()
//            }
//            composable(Routes.NestedHomeScreen) {
//                NestedHomeScreen(navController = navController)
//            }
//            composable(Routes.NestedDetailScreen) {
//                NestedDetailScreen()
//            }
        }
    }
}