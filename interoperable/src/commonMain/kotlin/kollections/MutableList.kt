@file:JsExport

package kollections

import kollections.serializers.MutableListSerializer
import kotlinx.JsExport
import kotlinx.serialization.Serializable
import kotlin.collections.MutableList as KMutableList

@Serializable(with = MutableListSerializer::class)
interface MutableList<E> : List<E>, KMutableList<E>, MutableCollection<E>