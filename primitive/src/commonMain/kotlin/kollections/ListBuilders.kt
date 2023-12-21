package kollections

import kotlin.collections.List as KList
import kotlin.collections.Set as KSet

import kollections.List // K2 fails if this is removed

expect inline fun <T> emptyList() : List<T>

expect inline fun <T> listOf() : List<T>

expect inline fun <T> listOf(vararg items: T) : List<T>

expect inline fun <T> mutableListOf() : MutableList<T>

expect inline fun <T> mutableListOf(vararg items: T) : MutableList<T>

expect inline fun <T> Iterable<T>.toList(): List<T>

expect inline fun <T> Iterable<T>.toMutableList(): MutableList<T>

expect inline fun <T> KList<T>.toList(): List<T>

expect inline fun <T> KSet<T>.toList(): List<T>