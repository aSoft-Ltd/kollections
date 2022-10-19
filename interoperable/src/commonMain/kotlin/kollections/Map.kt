@file:JsExport

package kollections

import kollections.serializers.MapSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.Map as KMap
import kotlin.js.JsExport

@Serializable(with = MapSerializer::class)
interface Map<K, out V> : KMap<K, V>, Collection<MapEntry<K, V>> {
    override val size: Int
    override val keys: Set<K>
    override val values: Collection<V>
    val pairs: Set<MapEntry<K, V>>
    override fun containsKey(key: K): Boolean = keys.contains(key)

    override fun containsValue(value: @UnsafeVariance V): Boolean = values.contains(value)

    override operator fun get(key: K): V?
}