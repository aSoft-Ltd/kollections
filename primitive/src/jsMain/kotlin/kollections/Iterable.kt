package kollections

import kollections.internal.Iterator

actual external interface Iterable<out T> {
    fun forEach(fn: (item: T) -> Unit)

    fun values(): Iterator<T>
    fun toArray() : List<T>
}