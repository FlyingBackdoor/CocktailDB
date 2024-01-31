package dev.sohair.cocktaildb.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class DrinkResultDto(
    val drinks: List<DrinkDto>?
)
