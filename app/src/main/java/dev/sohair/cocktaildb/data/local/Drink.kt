package dev.sohair.cocktaildb.data.local

import kotlinx.serialization.Serializable

@Serializable()
data class Drink(
    val name: String,
    val category: String,
    val iba: String,
    val imageUrl: String,
    val instruction: String,
    val glass: String
)
