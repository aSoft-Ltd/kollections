package kollections

actual fun <T> Iterable<T>.forEach(block: (item: T) -> Unit) = forEach(block)

actual fun <T> Iterable<T>.forEachIndexed(block: (index: Int, item: T) -> Unit) {
    var index = 0
    forEach { block(index++, it) }
}

actual fun <T> Iterable<T>.firstOrNull(predicate: (item: T) -> Boolean): T? {
    var found: T? = null
    forEach {
        if (predicate(it)) {
            found = it
            return@forEach
        }
    }
    return found
}

actual fun <T> Iterable<T>.find(predicate: (item: T) -> Boolean): T? = firstOrNull(predicate)

actual fun <T> Iterable<T>.all(predicate: (item: T) -> Boolean): Boolean = unsafeCast<Array<T>>().all(predicate)

actual fun <T> Iterable<T>.joinToString(
    separator: CharSequence,
    prefix: CharSequence,
    postfix: CharSequence,
    limit: Int,
    truncated: CharSequence,
    transform: ((T) -> CharSequence)?
): String = unsafeCast<Array<T>>().joinToString(separator, prefix, postfix, limit, truncated, transform)

actual inline fun <reified R> Iterable<*>.filterIsInstance(): List<R> = buildList {
    this@filterIsInstance.forEach { if (it is R) push(it) }
}

actual fun <T> Iterable<T>.toMutableList(): MutableList<T> = buildMutableList {
    this@toMutableList.forEach { push(it) }
}
actual inline fun <T> Iterable<T>.toList(): List<T> = toMutableList()

actual fun <T> Iterable<T>.toMutableSet(): MutableSet<T> = buildMutableSet {
    this@toMutableSet.forEach { add(it) }
}
actual inline fun <T> Iterable<T>.toSet(): Set<T> = toMutableSet()

actual fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = buildMap {
    this@associate.forEach {
        val (key, value) = fn(it)
        set(key, value)
    }
}

actual fun <T> Iterable<T>.reversed() : List<T> = toList().unsafeCast<Array<T>>().reversed().unsafeCast<List<T>>()