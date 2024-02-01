package dev.sohair.cocktaildb.data.remote

import dev.sohair.cocktaildb.domain.NetworkResult
import kotlinx.coroutines.flow.Flow

interface DrinksApi {

    suspend fun searchCocktailByName(query: String): Flow<NetworkResult<DrinkResultDto>>
}
