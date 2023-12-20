@file:Suppress("NON_EXTERNAL_TYPE_EXTENDS_EXTERNAL_TYPE")

package kollections

expect interface MutableList<T> : List<T>

expect fun <T> MutableList<T>.add(item: T)

expect fun <T> MutableList<T>.add(index: Int, item: T)

expect fun <T> MutableList<T>.addAll(vararg items: T)

expect fun <T> MutableList<T>.addAll(items: List<T>)

expect fun <T> MutableList<T>.addAll(items: Iterable<T>)

expect fun <T> MutableList<T>.addAll(items: Array<T>)

expect fun <T> MutableList<T>.remove(item: T): T?

expect fun <T> MutableList<T>.removeAll(items: Iterable<T>)

expect fun <T> MutableList<T>.clear()
