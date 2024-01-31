package dev.sohair.cocktaildb.presentation.ui.cocktail_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CocktailDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CocktailDetailViewModel,
    navController: NavController
) {
    Box(modifier = modifier) {
        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Go back")
        }
    }

}