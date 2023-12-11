@file:JsExport

package kollections

import kollections.serializers.MutableSetSerializer
import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlin.collections.MutableSet as KMutableSet

@Serializable(with = MutableSetSerializer::class)
interface MutableSet<E> : Set<E>, KMutableSet<E>, MutableCollection<E>