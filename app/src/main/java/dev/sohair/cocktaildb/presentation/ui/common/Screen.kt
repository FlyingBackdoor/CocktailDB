package dev.sohair.cocktaildb.presentation.ui.common

sealed class Screen(val route: String) {
    data object Home : Screen("homeScreen")

    data object DetailPage: Screen("detailScreen")
}
