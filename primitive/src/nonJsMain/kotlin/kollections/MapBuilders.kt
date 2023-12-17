package kollections

import kotlin.collections.mapOf as kMapOf
import kotlin.collections.mutableMapOf as kMutableMapOf

actual inline fun <K, V> mapOf(): Map<K, V> = kMapOf()

actual inline fun <K, V> mapOf(vararg entries: Pair<K, V>): Map<K, V> = kMapOf(*entries)

actual inline fun <K, V> mutableMapOf(): MutableMap<K, V> = kMutableMapOf()

actual inline fun <K, V> mutableMapOf(vararg entries: Pair<K, V>): MutableMap<K, V> = kMutableMapOf(*entries)