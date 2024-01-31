package dev.sohair.cocktaildb.data.remote

import dev.sohair.cocktaildb.domain.Constants.API_BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.appendPathSegments
import io.ktor.http.path

class DrinksApiImpl(private val client: HttpClient) : DrinksApi {

    private val drinksPathSegments = listOf("api", "json", "v1", "1")
    override suspend fun searchCocktailByName(query: String): DrinkResultDto {
        return client.get(API_BASE_URL) {
            url {
                appendPathSegments(drinksPathSegments + "search.php")
                parameter("s", query)
            }
        }.body()
    }

}