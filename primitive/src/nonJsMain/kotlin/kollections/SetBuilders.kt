@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.Set as KSet
import kotlin.collections.List as KList
import kotlin.collections.toSet as kToSet
import kotlin.collections.toMutableSet as kToMutableSet

actual inline fun <T> emptySet(): Set<T> = kotlin.collections.emptySet<T>() as Set<T>
actual inline fun <T> setOf(): Set<T> = kotlin.collections.setOf<T>() as Set<T>

actual inline fun <T> setOf(vararg items: T): Set<T> = kotlin.collections.setOf(*items) as Set<T>

actual inline fun <T> mutableSetOf(): MutableSet<T> = kotlin.collections.mutableSetOf()

actual inline fun <T> mutableSetOf(vararg items: T): MutableSet<T> = kotlin.collections.mutableSetOf(*items)

actual inline fun <T> Iterable<T>.toSet() : Set<T> = kToSet()

actual inline fun <T> Iterable<T>.toMutableSet(): MutableSet<T> = kToMutableSet()

actual inline fun <T> KSet<T>.toSet(): Set<T> = this

actual inline fun <T> KList<T>.toSet(): Set<T> = kToSet()