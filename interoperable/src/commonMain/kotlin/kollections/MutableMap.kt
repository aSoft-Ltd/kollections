@file:JsExport

package kollections

import kollections.serializers.MutableMapSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.MutableMap as KMutableMap
import kotlin.js.JsExport

@Serializable(with = MutableMapSerializer::class)
interface MutableMap<K, V> : Map<K, V>, KMutableMap<K, V> {
    override val size: Int
    override val keys: MutableSet<K>
    override val values: MutableCollection<V>

    override fun put(key: K, value: V): V?

    override fun clear()
    override fun remove(key: K): V?
}