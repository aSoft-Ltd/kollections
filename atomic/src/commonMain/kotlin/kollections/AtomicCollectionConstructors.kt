package kollections

expect fun <E> mutableAtomicListOf(vararg elements: E): MutableList<E>

expect fun <K, V> mutableAtomicMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V>