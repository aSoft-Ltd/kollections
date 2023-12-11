@file:JsExport @file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kotlin.collections.Map as KMap
import kotlinx.JsExport

interface MapLike<K, out V> : KMap<K, V>, CollectionLike<MapEntry<K, V>> {
    override val size: Int
    override val keys: Set<K>
    override val values: Collection<V>

    val pairs: Set<MapEntry<K, V>>

    override fun containsKey(key: K): Boolean = keys.contains(key)

    override fun containsValue(value: @UnsafeVariance V): Boolean = values.contains(value)

    override operator fun get(key: K): V?

    fun getValue(key: K): V
}