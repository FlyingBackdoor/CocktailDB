package dev.sohair.cocktaildb.presentation.ui.common.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.sohair.cocktaildb.data.local.Drink
import dev.sohair.cocktaildb.domain.Utils.decodeSlash
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
        /*
        A simple example of nave arguments, splits for redablity
        Another possible way is to serialize to Json string
        */
        composable(
            route = Screen.DetailPage.route + "/{name}/{category}/{imageUrl}/{instruction}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("category") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType },
                navArgument("instruction") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            var drink: Drink? = null
            backStackEntry.arguments?.let {
                drink = Drink(
                    name = it.getString("name", "").decodeSlash(),
                    category = it.getString("category", "").decodeSlash(),
                    imageUrl = it.getString("imageUrl", "").decodeSlash(),
                    instruction = it.getString("instruction", "").decodeSlash(),
                    iba = "",
                    glass = ""
                )
            }
            CocktailDetailScreen(
                modifier = defaultModifier,
                viewModel = hiltViewModel(),
                navController = navController,
                drink = drink
            )
        }
    }

}