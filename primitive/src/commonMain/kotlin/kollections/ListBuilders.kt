package kollections

import kotlin.collections.List as KList

expect inline fun <reified T> listOf() : List<T>

expect inline fun <reified T> listOf(vararg items: T) : List<T>

expect inline fun <reified T> mutableListOf() : MutableList<T>

expect inline fun <reified T> mutableListOf(vararg items: T) : MutableList<T>

expect inline fun <reified T> KList<T>.toList(): List<T>