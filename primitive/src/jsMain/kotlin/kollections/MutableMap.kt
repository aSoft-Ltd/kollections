@file:Suppress("NON_EXTERNAL_TYPE_EXTENDS_EXTERNAL_TYPE")

package kollections

@JsName("Map")
actual external interface MutableMap<K, V> : Map<K, V> {
    fun set(key: K, value: V)
}