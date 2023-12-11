@file:JsExport

package kollections

import kollections.serializers.MapSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.Map as KMap
import kotlinx.JsExport

@Serializable(with = MapSerializer::class)
interface Map<K, out V> : MapLike<K, V>, Collection<MapEntry<K, V>>