package kollections.internal

import kollections.MapEntry

internal data class MapEntryImpl<K, V>(
    override val key: K,
    override val value: V
) : MapEntry<K, V> {
    override val k: K get() = key
    override val v: V get() = value
}
