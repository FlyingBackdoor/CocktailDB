package dev.sohair.cocktaildb.data.local

import kotlinx.serialization.Serializable

/**
 * Drink class will be utilized by UI states
 * */
@Serializable()
data class Drink(
    val name: String,
    val category: String,
    val iba: String,
    val imageUrl: String,
    val instruction: String,
    val glass: String
)
