package kollections


actual inline fun <E> mutableAtomicListOf(vararg elements: E): MutableList<E> = mutableListOf(*elements)

actual inline fun <K, V> mutableAtomicMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V> = mutableMapOf(*pairs)