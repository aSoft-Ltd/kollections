@file:Suppress("NON_EXTERNAL_TYPE_EXTENDS_EXTERNAL_TYPE")

package kollections

expect interface MutableMap<K, V> : Map<K, V> {
    fun clear()
}

expect inline operator fun <K, V> MutableMap<K, V>.set(key: K, value: V)

expect inline fun <K, V> MutableMap<K, V>.put(key: K, value: V): V?

expect inline fun <K, V> MutableMap<K, V>.putAll(from: Map<K, V>)