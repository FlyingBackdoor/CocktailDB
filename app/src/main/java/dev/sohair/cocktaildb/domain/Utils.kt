package dev.sohair.cocktaildb.domain

object Utils {

    /*The following will encode and decode slash as needed for creating nav arguments
    * */
    fun String.encodeSlash(): String {
        return replace("/", "~")
    }

    fun String.decodeSlash(): String {
        return replace("~", "/")
    }
}