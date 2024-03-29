@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.toMutableSet
import kotlin.collections.List as KList
import kotlin.collections.Set as KSet
import kotlin.collections.toSet as kToSet
import kotlin.collections.Iterable as KIterable
import kotlin.collections.toList as kToList
import kotlin.collections.toMutableList as kToMutableList
actual inline fun <T> emptyList(): List<T> = kotlin.collections.emptyList<T>() as List<T>
actual inline fun <T> listOf(): List<T> = kotlin.collections.listOf<T>() as List<T>

actual inline fun <T> listOf(vararg items: T): List<T> = kotlin.collections.listOf(*items) as List<T>

actual inline fun <T> mutableListOf(): MutableList<T> = kotlin.collections.mutableListOf()

actual inline fun <T> mutableListOf(vararg items: T): MutableList<T> = kotlin.collections.mutableListOf(*items)

actual inline fun <T> KSet<T>.toList(): List<T> = kToList()

actual inline fun <T> Iterable<T>.toMutableList(): MutableList<T> = kToMutableList()

actual inline fun <T> KList<T>.toList(): List<T> = this

actual inline fun <T> Iterable<T>.toList(): List<T> = kToList()