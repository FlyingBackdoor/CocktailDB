package dev.sohair.cocktaildb.presentation.ui.cocktail_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.sohair.cocktaildb.data.local.Drink

/**
 * Just a basic screen
 * */
@Composable
fun CocktailDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CocktailDetailViewModel,
    navController: NavController,
    drink: Drink?
) {
    Scaffold(modifier = modifier,
        topBar = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        }) {
        Column(
            modifier = modifier
                .padding(it)
                .padding(16.dp)
        ) {
            drink?.let { drink ->
                AsyncImage(
                    model = drink.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = drink.name, fontWeight = FontWeight.SemiBold, fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Category ${drink.category}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Instruction: ${drink.instruction}")
            }
        }
    }
}
