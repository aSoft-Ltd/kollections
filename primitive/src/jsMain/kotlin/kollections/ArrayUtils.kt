package kollections

actual inline fun <T, R> Array<out T>.map(fn: (item: T) -> R): List<R> = buildList {
    forEach { item: T -> push(fn(item)) }
}

actual fun <T, R> Array<out T>.mapIndexed(fn: (index: Int, item: T) -> R): List<R> = buildList {
    var index = 0
    forEach { item: T -> push(fn(index++, item)) }
}

actual fun <T, K, V> Array<out T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = buildMap {
    forEach { item: T ->
        val (key, value) = fn(item)
        set(key, value)
    }
}

actual fun <T> Array<T>.toList() = unsafeCast<List<T>>()