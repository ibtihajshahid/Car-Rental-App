package com.example.carrentalapp.presentation.ui.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.carrentalapp.R
import com.example.carrentalapp.presentation.common.Viewmodels.OnboardingViewModel
import com.example.carrentalapp.presentation.navigation.Routes.Routes
import com.example.carrentalapp.presentation.ui.shared.OnBoardModel
import com.example.carrentalapp.presentation.ui.shared.SharedPrefsHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)


@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController = rememberNavController()
) {
    val context = LocalContext.current
    val sharedPrefsHelper = SharedPrefsHelper(context)
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()


    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->

        when (page) {

            0 -> OnboardingScreen1(

            )

            1 -> OnboardingScreen2()
            2 -> OnboardingScreen3()
        }


    }
    // Start Skip and Next Animation
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {

        Row(
            modifier = Modifier.padding(bottom = 55.dp,).clip(shape = RoundedCornerShape(20.dp)),

            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Text(
                "Skip",
                style = TextStyle(
                    color = Color(0xFFFFFFFF),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(horizontal = 55.dp,).clickable {
                    if (pagerState.currentPage < 2) {
                        coroutineScope.launch {

                            pagerState.animateScrollToPage(pagerState.currentPage + 3)
                        }
                    } else {
                        navController.navigate(Routes.LoginScreen)
                    }
                }
            )
            repeat(3) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .width(if (isSelected) 18.dp else 10.dp)
                        .height(10.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .background(
                            color = if (isSelected) Color(0xFF2596be) else Color(0xFFFFFFFF),
                            shape = CircleShape
                        )
                )
            }

            Text(
                "Next",
                style = TextStyle(
                    color = Color(0xFFFFFFFF),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(horizontal = 55.dp,).clickable {
                    if (pagerState.currentPage < 2) {
                        coroutineScope.launch {
                            if (pagerState.currentPage < pagerState.currentPage + 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    } else {
                        navController.navigate(Routes.LoginScreen)
                    }
                }
            )
        }

    }


}

// Start Onboarding Screens
@Composable
fun OnboardingScreen1() {

    Box(
        modifier = Modifier
            .fillMaxSize(),


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize(),
            ) {
                // Image background
                Image(
                    painter = painterResource(R.drawable.car),
                    contentDescription = "Car Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )


                // Text overlay
                Column (modifier = Modifier.fillMaxSize() .background(
                    // Linear Gradient Overlay (Black to White)
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  // Start with black at the top
                            Color.Black.copy(alpha = 0.8f)   // Transition to white at the bottom
                        )
                    )
                ).padding(top = 300.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Row (modifier = Modifier.padding( 50.dp),){
                        Text(text = "Make it easy for users to quickly " +
                             "book a ride from their current location with just a few taps.",
                          modifier = Modifier.padding(top = 150.dp),
                            color = Color.White, fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun OnboardingScreen2() {

    Box(
        modifier = Modifier
            .fillMaxSize()


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize(),
            ) {
                // Image background
                Image(
                    painter = painterResource(R.drawable.jeep),
                    contentDescription = "Car Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )


                // Text overlay
                Column (modifier = Modifier.fillMaxSize() .background(
                    // Linear Gradient Overlay (Black to White)
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  // Start with black at the top
                            Color.Black.copy(alpha = 0.8f)   // Transition to white at the bottom
                        )
                    )
                ).padding(top = 300.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Row (modifier = Modifier.padding( 44.dp),){
                        Text(text = "Provide a variety of vehicle options " +
                                "to choose from, catering to."+ "different preferences "+" and budges",
                            modifier = Modifier.padding(top = 150.dp), color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center,
                        )
                    }
                }

            }
        }
    }

}


@Composable
fun OnboardingScreen3() {

    Box(
        modifier = Modifier
            .fillMaxSize()


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize(),
            ) {
                // Image background
                Image(
                    painter = painterResource(R.drawable.blackcar),
                    contentDescription = "Car Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Text overlay
                Column (modifier = Modifier.fillMaxSize() .background(
                    // Linear Gradient Overlay (Black to White)
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  // Start with black at the top
                            Color.Black.copy(alpha = 0.8f)   // Transition to white at the bottom
                        )
                    )
                ).padding(top = 300.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Row (modifier = Modifier.padding( 44.dp),){
                        Text(text = "Let users track their ride in real- " +
                                "time, so they know exactly where" + " their driver is and when they'll arrive.",
                            modifier = Modifier.padding(top = 150.dp), color = Color.White, fontSize = 20.sp, textAlign = TextAlign.Center )
                    }
                }

            }
        }
    }
}


