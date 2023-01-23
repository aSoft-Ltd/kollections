package kollections

import kollections.internal.MutableAtomicList
import kollections.internal.MutableAtomicMap

fun <E> mutableAtomicListOf(vararg elements: E): MutableList<E> {
    return MutableAtomicList(mutableListOf(*elements))
}

fun <K, V> mutableAtomicMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V> {
    return MutableAtomicMap(pairs.toMap().toMutableMap())
}