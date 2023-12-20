package kollections

expect fun <T> Iterable<T>.forEach(block: (item: T) -> Unit)

expect fun <T> Iterable<T>.forEachIndexed(block: (index: Int, item: T) -> Unit)
expect fun <T> Iterable<T>.find(predicate: (item: T) -> Boolean): T?

expect fun <T> Iterable<T>.all(predicate: (item: T) -> Boolean): Boolean

expect fun <T> Iterable<T>.any(predicate: (item: T) -> Boolean): Boolean

expect fun <T> Iterable<T>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
): String

expect fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V>

expect fun <T,V> Iterable<T>.associateWith(fn: (item: T) -> V): Map<T, V>
expect fun <K, T> Iterable<T>.associateBy(fn: (item: T) -> K): Map<K, T>

expect inline fun <reified R> Iterable<*>.filterIsInstance(): List<R>

expect fun <T> Iterable<T>.toList(): List<T>

expect fun <T> Iterable<T>.toMutableList(): MutableList<T>

expect fun <T> Iterable<T>.toSet(): Set<T>

expect fun <T> Iterable<T>.toMutableSet(): MutableSet<T>

expect fun <T> Iterable<T>.reversed(): List<T>

expect inline fun <T> Iterable<T>.chunked(size: Int) : List<List<T>>

expect fun <T> Iterable<T>.first(): T

expect fun <T> Iterable<T>.firstOrNull(): T?

expect fun <T> Iterable<T>.first(predicate: (item: T) -> Boolean): T

expect fun <T> Iterable<T>.firstOrNull(predicate: (item: T) -> Boolean): T?

expect fun <T> Iterable<T>.last(): T

expect fun <T> Iterable<T>.lastOrNull(): T?

expect fun <T> Iterable<T>.last(predicate: (item: T) -> Boolean): T
expect fun <T> Iterable<T>.lastOrNull(predicate: (item: T) -> Boolean): T?

expect fun <T> Iterable<T>.filter(predicate: (item: T) -> Boolean) : List<T>

expect inline fun <T, R : Comparable<R>> Iterable<T>.sortedBy(crossinline selector: (T) -> R?):List<T>
expect inline fun <T, R : Comparable<R>> Iterable<T>.sortedByDescending(crossinline selector: (T) -> R?) : List<T>