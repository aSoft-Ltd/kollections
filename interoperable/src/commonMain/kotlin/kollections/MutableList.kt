@file:JsExport

package kollections

import kollections.serializers.MutableListSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.Collection
import kotlin.js.JsExport
import kotlin.collections.MutableList as KMutableList
import kotlin.js.JsName

@Serializable(with = MutableListSerializer::class)
interface MutableList<E> : List<E>, KMutableList<E>, MutableCollection<E>