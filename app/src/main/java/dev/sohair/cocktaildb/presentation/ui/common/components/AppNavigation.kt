package dev.sohair.cocktaildb.presentation.ui.common.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.sohair.cocktaildb.presentation.ui.cocktail_detail.CocktailDetailScreen
import dev.sohair.cocktaildb.presentation.ui.common.Screen
import dev.sohair.cocktaildb.presentation.ui.home.HomeScreen

/**
 * This composable function handles all the navigation logic
 * It will maintain the nav backstack
 * @param navController must be passed from [MainActivity]
 * */
@Composable
fun AppNavigation(navController: NavHostController) {
    val defaultModifier = Modifier.fillMaxSize()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        /*Home Screen*/
        composable(route = Screen.Home.route) {
            HomeScreen(
                modifier = defaultModifier,
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

        /*Detail Screen*/
        composable(route = Screen.DetailPage.route) {
            CocktailDetailScreen(
                modifier = defaultModifier,
                viewModel = hiltViewModel(),
                navController = navController
            )
        }
    }

}