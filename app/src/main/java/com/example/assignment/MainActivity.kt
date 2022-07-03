package com.example.assignment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment.model.Items
import com.example.assignment.navigation.NavRoutes
import com.example.assignment.screen.DetailsScreen
import com.example.assignment.screen.Home
import com.jetpack.callapimvvm.ui.theme.CallApiMVVMTheme
import com.jetpack.callapimvvm.ui.theme.Purple500
import com.jetpack.callapimvvm.utils.Resource
import com.example.assignment.view.UserListItem
import com.example.assignment.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            setContent {
//                CallApiMVVMTheme {
//                    CallApi()
//                }
//            }

            val navController = rememberNavController()


                    NavigationComponent(navController)

        }
    }
    @Composable
    fun NavigationComponent(navController: NavHostController) {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = NavRoutes.Home.route,
        ) {
            composable(NavRoutes.Home.route) {
                Home(navController = navController)
            }
            composable(NavRoutes.DetailScreen.route) {
                DetailsScreen(navController = navController)
            }


        }
    }



}