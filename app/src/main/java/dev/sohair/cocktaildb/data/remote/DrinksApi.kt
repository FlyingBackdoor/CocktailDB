package dev.sohair.cocktaildb.data.remote

interface DrinksApi {

    suspend fun searchCocktailByName(query: String): DrinkResultDto
}