@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "WRONG_EXPORTED_DECLARATION")

package kollections

import kollections.serializers.ListSerializer
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlin.collections.List
import kotlin.js.JsExport
import kotlin.collections.List as KList

@Serializable(with = ListSerializer::class)
interface List<out E> : Collection<E>, KList<E> {
    override operator fun get(index: Int): E

    override fun indexOf(element: @UnsafeVariance E): Int

    override fun lastIndexOf(element: @UnsafeVariance E): Int
}