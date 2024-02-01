package dev.sohair.cocktaildb.presentation.ui.home

import dev.sohair.cocktaildb.data.local.Drink

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val drinks: List<Drink> = emptyList(),
    val errorMessage: String? = null
)
