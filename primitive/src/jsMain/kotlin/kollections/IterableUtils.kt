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

actual fun <T> Iterable<T>.joinToString(
    separator: CharSequence,
    prefix: CharSequence,
    postfix: CharSequence,
    limit: Int,
    truncated: CharSequence,
    transform: ((T) -> CharSequence)?
): String = unsafeCast<Array<T>>().joinToString(separator, prefix, postfix, limit, truncated, transform)

actual inline fun <reified R> Iterable<*>.filterIsInstance(): List<R> = buildList {
    forEach { item: Any? -> if (item is R) push(item) }
}

actual fun <T> Iterable<T>.toList(): List<T> = buildList { forEach { push(it) } }

actual fun <T> Iterable<T>.toSet(): Set<T> = buildSet { forEach { add(it) } }

actual fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = buildMap {
    forEach { item: T ->
        val (key, value) = fn(item)
        set(key, value)
    }
}