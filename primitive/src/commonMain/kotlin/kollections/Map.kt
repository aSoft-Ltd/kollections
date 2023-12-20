package kollections

expect interface Map<K, out V>


expect val <K, V> Map<K, V>.size: Int

expect val <K, V> Map<K, V>.entries: Set<MapEntry<K, V>>

expect val <K, V> Map<K, V>.keys: Set<K>

expect val <K, V> Map<K, V>.values: Collection<V>
expect inline operator fun <K, V> Map<K, V>.get(key: K): V?

expect inline fun <K, V> Map<K, V>.getValue(key: K): V

expect inline fun <K, V> Map<K, V>.containsKey(key: K): Boolean