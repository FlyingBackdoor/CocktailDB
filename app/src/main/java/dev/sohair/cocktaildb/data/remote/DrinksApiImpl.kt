package dev.sohair.cocktaildb.data.remote

import android.util.Log
import dev.sohair.cocktaildb.domain.Constants.API_BASE_URL
import dev.sohair.cocktaildb.domain.NetworkResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DrinksApiImpl(private val client: HttpClient) : DrinksApi {

    //common segments same for all end point
    private val drinksPathSegments = listOf("api", "json", "v1", "1")
    override suspend fun searchCocktailByName(query: String): Flow<NetworkResult<DrinkResultDto>> {
        return flow {
            emit(NetworkResult.Loading)
            val result = client.get(API_BASE_URL) {
                url {
                    appendPathSegments(drinksPathSegments + "search.php") //search is unique for this specific call
                    parameter("s", query)
                }
            }.body<DrinkResultDto>()
            emit(NetworkResult.Success(result))
        }
            .catch { t ->
                Log.e("DrinksAPI", "searchCocktailByName: flow caught error", t)
                NetworkResult.Error(Exception("Unable to fetch", t))
            }
            .flowOn(Dispatchers.IO)

    }

}
