package dev.sohair.cocktaildb.presentation.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.sohair.cocktaildb.R
import dev.sohair.cocktaildb.domain.Utils.encodeSlash
import dev.sohair.cocktaildb.presentation.ui.common.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel,
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value

    Column(modifier = modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(id = R.string.home_headline),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        TextField(
            value = viewModel.searchText.value,
            onValueChange = viewModel::onSearchTextChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(id = R.string.text_search)
                )
            },
            trailingIcon = {
                AnimatedVisibility(visible = viewModel.searchText.value.isNotEmpty()) {
                    IconButton(onClick = { viewModel.onSearchTextChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            },
            placeholder = { Text(text = stringResource(id = R.string.text_search)) },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(24.dp))
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                text = stringResource(id = R.string.text_near_restaurant),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stringResource(id = R.string.cta_see_all),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        RowItem() //Hardcoded Item
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = state.isLoading,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            CircularProgressIndicator()
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(state.drinks) { item ->
                DrinkItem(item = item) {
                    navController.navigate(
                        Screen.DetailPage.route + "/${it.name.encodeSlash()}/${it.category.encodeSlash()}" +
                                "/${it.imageUrl.encodeSlash()}/${it.instruction.encodeSlash()}"
                    )

                }
            }
        }
    }
}