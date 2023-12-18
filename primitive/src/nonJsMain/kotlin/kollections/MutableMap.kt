package kollections

import kotlin.collections.set as kSet

actual typealias MutableMap<K, V> = kotlin.collections.MutableMap<K, V>

actual inline operator fun <K, V> MutableMap<K, V>.set(key: K, value: V) = kSet(key, value)
actual inline fun <K, V> MutableMap<K, V>.put(key: K, value: V) = put(key, value)
actual inline fun <K, V> MutableMap<K, V>.putAll(from: Map<K, V>) = putAll(from)