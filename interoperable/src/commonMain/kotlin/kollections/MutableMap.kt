@file:JsExport

package kollections

import kollections.serializers.MutableMapSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.MutableMap as KMutableMap
import kotlin.js.JsExport

@Serializable(with = MutableMapSerializer::class)
interface MutableMap<K, V> : MutableMapLike<K, V>, Map<K, V>