package kollections

import kotlin.collections.Map as KMap

@PublishedApi
internal fun <K,V> newMap(vararg entries: Pair<K, V>) : MutableMap<K,V> {
    val iterable = entries.map { arrayOf(it.first,it.second) }.toTypedArray()
    return js("new Map(iterable)")
}

actual inline fun <K, V> mapOf(): Map<K, V> = js("new Map()")

actual inline fun <K, V> mapOf(vararg entries: Pair<K, V>): Map<K, V> = newMap(*entries)

actual inline fun <K, V> mutableMapOf(): MutableMap<K, V> = js("new Map()")

actual inline fun <K, V> mutableMapOf(vararg entries: Pair<K, V>): MutableMap<K, V> = newMap(*entries)

//expect inline fun <K, V> mutableMapOf(vararg items: T) : MutableMap<K, V>

//expect inline fun <K, V> KMap<K, V>.toMap(): Map<K, V>