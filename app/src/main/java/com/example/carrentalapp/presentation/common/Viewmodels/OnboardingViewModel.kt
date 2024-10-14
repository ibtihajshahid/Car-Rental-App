package com.example.carrentalapp.presentation.common.Viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.carrentalapp.presentation.navigation.Routes.Routes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


//class OnboardingViewModel : ViewModel() {
//    private val _currentPage = MutableStateFlow(0)
//    val currentPage: StateFlow<Int> = _currentPage
//
//    fun nextPage() {
//        _currentPage.value = _currentPage.value + 1
//    }
//
//    fun previousPage() {
//        _currentPage.value = if (_currentPage.value > 0) _currentPage.value - 1 else 0
//    }
//
//    fun onPageChange(page: Int) {
//        _currentPage.value = page
//    }
//
//    fun navigateToLogin(navController: NavController) {
//        navController.navigate(Routes.LoginScreen)
//    }
//}
class OnboardingViewModel : ViewModel() {

    private val _currentPage = MutableStateFlow(0)
    val currentPage: StateFlow<Int> = _currentPage

    fun nextPage() {
        _currentPage.value++
    }

    fun navigateToLoginScreen(navController: NavController) {
        navController.navigate("LoginScreen")
    }
}
