@file:Suppress("NON_EXTERNAL_TYPE_EXTENDS_EXTERNAL_TYPE")

package kollections

expect interface MutableList<T> : List<T>

expect fun <T> MutableList<T>.add(item: T)

expect fun <T> MutableList<T>.addAll(vararg items: T)

expect fun <T> MutableList<T>.addAll(items: List<T>)

expect fun <T> MutableList<T>.addAll(items: Iterable<T>)

expect fun <T> MutableList<T>.addAll(items: Array<T>)

expect operator fun <T> MutableList<T>.plus(item: T)

expect operator fun <T> MutableList<T>.plus(items: Iterable<T>)

expect fun <T> MutableList<T>.remove(item: T) : T?

expect fun <T> MutableList<T>.removeAll(items: Iterable<T>)

expect operator fun <T> MutableList<T>.minus(item: T)
