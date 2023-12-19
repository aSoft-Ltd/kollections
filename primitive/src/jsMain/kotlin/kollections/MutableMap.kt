@file:Suppress("NON_EXTERNAL_TYPE_EXTENDS_EXTERNAL_TYPE")

package kollections

@JsName("Map")
actual external interface MutableMap<K, V> : Map<K, V> {
    fun set(key: K, value: V): MutableMap<K, V>

    fun delete(key: K) : Boolean
    actual fun clear()
}

actual inline operator fun <K, V> MutableMap<K, V>.set(key: K, value: V) {
    set(key, value)
}
actual inline fun <K, V> MutableMap<K, V>.put(key: K, value: V): V? {
    set(key, value)
    return value
}

actual inline fun <K, V> MutableMap<K, V>.putAll(from: Map<K, V>) {
    from.forEach { value, key -> set(key, value) }
}

actual inline fun <K, V> MutableMap<K, V>.remove(key: K) : V? {
    if(!has(key)) return null
    val v = get(key)
    delete(key)
    return v
}