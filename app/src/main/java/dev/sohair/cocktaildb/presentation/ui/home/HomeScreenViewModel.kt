package dev.sohair.cocktaildb.presentation.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.sohair.cocktaildb.data.remote.DrinksApi
import dev.sohair.cocktaildb.domain.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val api: DrinksApi) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenUiState())
    val state: StateFlow<HomeScreenUiState> = _state

    val searchText = mutableStateOf("")

    fun onSearchTextChange(query: String) {
        searchText.value = query
        searchDrink(query)
    }

    private fun searchDrink(query: String) {
        //at-least 3 chars are required to search, this will optimize the api calls
        if (query.length < 2) return

        //Making network call and collecting the result
        viewModelScope.launch(Dispatchers.IO) {
            val result = api.searchCocktailByName(query)
            result
                //using collectLatest so if query updated quickly we will ignore the previous result
                .collectLatest { networkResult ->
                    when (networkResult) {
                        is NetworkResult.Error -> {
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    isError = true,
                                    errorMessage = networkResult.exception.message
                                )
                            }
                        }

                        NetworkResult.Loading -> {
                            _state.update { it.copy(isLoading = true) }
                        }

                        is NetworkResult.Success -> {
                            _state.update {
                                it.copy(isLoading = false,
                                    isError = false,
                                    errorMessage = null,
                                    drinks = networkResult.data.drinks?.map { dto ->
                                        dto.toDrink()
                                    } ?: emptyList()
                                )
                            }
                        }
                    }
                }

        }
    }
}
