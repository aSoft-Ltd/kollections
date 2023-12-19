package kollections

import kotlin.collections.Iterator

actual external interface Iterable<out T> {
    fun forEach(fn: (item: T) -> Unit)

    fun filter(fn: (item: T) -> Boolean): Iterator<T>

    fun find(fn: (item: T) -> Boolean): T?

    fun <R> reduce(fn: (a: T, b: T) -> R): R

    fun toArray() : List<T>
}