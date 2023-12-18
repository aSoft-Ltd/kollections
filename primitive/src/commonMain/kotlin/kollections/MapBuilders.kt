package kollections

import kotlin.collections.Map as KMap

expect inline fun <K, V> mapOf(): Map<K, V>

expect inline fun <K, V> mapOf(vararg entries: Pair<K, V>): Map<K, V>

expect inline fun <K, V> mutableMapOf(): MutableMap<K, V>

expect inline fun <K, V> mutableMapOf(vararg entries: Pair<K, V>): MutableMap<K, V>

expect inline fun <K, V> Map<K, V>.toMutableMap(): MutableMap<K, V>

//expect inline fun <K, V> mutableMapOf(vararg items: T) : MutableMap<K, V>

//expect inline fun <K, V> KMap<K, V>.toMap(): Map<K, V>