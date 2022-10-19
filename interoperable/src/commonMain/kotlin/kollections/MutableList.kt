@file:JsExport

package kollections

import kollections.serializers.MutableListSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.Collection
import kotlin.js.JsExport
import kotlin.collections.MutableList as KMutableList

@Serializable(with = MutableListSerializer::class)
interface MutableList<E> : List<E>, KMutableList<E>, MutableCollection<E> {
    override fun add(index: Int, element: E)
}