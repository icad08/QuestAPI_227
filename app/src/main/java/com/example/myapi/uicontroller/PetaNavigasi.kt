package com.example.myapi.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapi.uicontroller.route.DestinasiDetail
import com.example.myapi.uicontroller.route.DestinasiEntry
import com.example.myapi.uicontroller.route.DestinasiHome
import com.example.myapi.view.EntrySiswaScreen
import com.example.myapi.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(
        navController = navController,
        modifier = modifier
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigateToItemUpdate = { idSiswa ->
                    navController.navigate("${DestinasiDetail.route}/$idSiswa")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }

        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.idSiswa) {
                type = NavType.IntType
            })
        ) {

        }
    }
}
