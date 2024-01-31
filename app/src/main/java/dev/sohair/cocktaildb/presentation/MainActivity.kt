package dev.sohair.cocktaildb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.sohair.cocktaildb.presentation.ui.common.components.AppNavigation
import dev.sohair.cocktaildb.presentation.ui.theme.CocktailDBTheme


/**
 * Copyrighted by @author Mohammad Sohair
 * This Application follows the MVVM and Single activity structure
 * */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CocktailDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Will keep the MainActivity Clean by using compose best practices.
                    AppNavigation(navController)

                }
            }
        }
    }
}
