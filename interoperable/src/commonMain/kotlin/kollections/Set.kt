@file:JsExport

package kollections

import kollections.serializers.SetSerializer
import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlin.collections.Set as KSet

@Serializable(with = SetSerializer::class)
interface Set<out E> : Collection<E>, KSet<E>