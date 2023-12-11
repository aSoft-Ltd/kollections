@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kotlin.collections.MutableMap as KMutableMap
import kotlinx.JsExport

interface MutableMapLike<K, V> : MapLike<K, V>, KMutableMap<K, V> {
    override val size: Int

    override val keys: MutableSet<K>

    override val values: MutableCollection<V>

    override fun put(key: K, value: V): V?

    override fun clear()

    override fun remove(key: K): V?

    operator fun set(key: K, value: V)
}