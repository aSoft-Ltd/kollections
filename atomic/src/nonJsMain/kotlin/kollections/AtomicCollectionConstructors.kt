package kollections

import kotlin.collections.mutableListOf as kMutableListOf
import kotlin.collections.mutableMapOf as kMutableMapOf
import kollections.internal.MutableAtomicList
import kollections.internal.MutableAtomicMap

actual inline fun <E> mutableAtomicListOf(vararg elements: E): MutableList<E> {
    return MutableAtomicList(kMutableListOf(*elements)) as MutableList<E> // removing the cast fails on Kw2
}

actual inline fun <K, V> mutableAtomicMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V> {
    return MutableAtomicMap(kMutableMapOf(*pairs)) as MutableMap<K, V>// removing the cast fails on Kw2
}