@file:JsExport

package kollections

import kotlin.collections.Collection as KCollection
import kotlinx.JsExport
import kotlinx.JsExportIgnore
import kotlinx.JsName

interface CollectionLike<out E> : Iterable<E>, KCollection<E> {

    override fun isEmpty(): Boolean

    override val size: Int

    override fun contains(element: @UnsafeVariance E): Boolean

    fun first(): E

    fun firstOrNull(): E?

    fun joinToString(separator: String = ", ", transformer: (E) -> String = { it.toString() }): String

    @JsName("_ignore_iterator")
    override fun iterator(): Iterator<E>
}