package kollections

expect fun <T> Iterable<T>.forEach(block: (item: T) -> Unit)

expect fun <T> Iterable<T>.forEachIndexed(block: (index: Int, item: T) -> Unit)
expect fun <T> Iterable<T>.firstOrNull(predicate: (item: T) -> Boolean): T?
expect fun <T> Iterable<T>.find(predicate: (item: T) -> Boolean): T?

expect fun <T> Iterable<T>.all(predicate: (item: T) -> Boolean): Boolean


expect fun <T> Iterable<T>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((T) -> CharSequence)? = null
): String

expect fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V>

expect inline fun <reified R> Iterable<*>.filterIsInstance(): List<R>

expect fun <T> Iterable<T>.toList(): List<T>

expect fun <T> Iterable<T>.toMutableList(): MutableList<T>

expect fun <T> Iterable<T>.toSet(): Set<T>
expect fun <T> Iterable<T>.toMutableSet(): MutableSet<T>

expect fun <T> Iterable<T>.reversed(): List<T>