package dev.sohair.cocktaildb.domain

object Utils {
    fun String.encodeSlash(): String {
        return replace("/", "~")
    }

    fun String.decodeSlash(): String {
        return replace("~", "/")
    }
}