@file:Suppress("NON_EXTERNAL_TYPE_EXTENDS_EXTERNAL_TYPE")

package kollections

expect interface MutableSet<T> : Set<T>

expect fun <T> MutableSet<T>.add(item: T)

expect fun <T> MutableSet<T>.addAll(vararg items: T)

expect fun <T> MutableSet<T>.addAll(items: Set<T>)

expect fun <T> MutableSet<T>.addAll(items: Collection<T>)

expect operator fun <T> MutableSet<T>.plus(item: T)

expect operator fun <T> MutableSet<T>.plus(items: Iterable<T>)

expect fun <T> MutableSet<T>.remove(item: T) : T?

expect fun <T> MutableSet<T>.removeAll(items: Iterable<T>)

expect operator fun <T> MutableSet<T>.minus(item: T)
