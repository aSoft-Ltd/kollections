package kollections

expect interface Map<K, out V>


expect val <K, V> Map<K, V>.size: Int

expect operator fun <K, V> Map<K, V>.get(key: K): V?