package kollections

//inline fun <K, V> MutableMap<K, V>.getOrPut(key: K, value: V): V {
//    if (containsKey(key)) return getValue(key)
//    put(key, value)
//    return value
//}

inline fun <K, V> MutableMap<K, V>.getOrPut(key: K, compute: () -> V): V {
    if (containsKey(key)) return getValue(key)
    val v = compute()
    put(key, v)
    return v
}

inline fun <K, V, R> Map<K, V>.mapValues(noinline fn: (MapEntry<K, V>) -> R): Map<K, R> = buildMap {
    this@mapValues.entries.forEach { put(it.key, fn(it)) }
}

inline fun <K, V, R> Map<K, V>.mapKeys(noinline fn: (MapEntry<K, V>) -> R): Map<R, V> = buildMap {
    this@mapKeys.entries.forEach { put(fn(it), it.value) }
}

inline fun <K, V> Map<K, V>.find(noinline fn: (MapEntry<K, V>) -> Boolean): MapEntry<K, V>? = entries.find(fn)

inline fun <K, V> Map<K, V>.isEmpty() = size == 0