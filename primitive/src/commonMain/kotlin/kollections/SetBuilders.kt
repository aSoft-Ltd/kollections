package kollections

import kotlin.collections.Set as KSet


expect inline fun <T> emptySet() : Set<T>

expect inline fun <T> setOf() : Set<T>

expect inline fun <T> setOf(vararg items: T) : Set<T>

expect inline fun <T> mutableSetOf() : MutableSet<T>

expect inline fun <T> mutableSetOf(vararg items: T) : MutableSet<T>

expect inline fun <T> KSet<T>.toSet(): Set<T>