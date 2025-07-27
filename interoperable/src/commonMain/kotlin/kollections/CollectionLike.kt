@file:JsExport

package kollections

import kotlinx.JsExport
import kotlin.collections.Collection as KCollection

interface CollectionLike<out E> : Iterable<E>, KCollection<E> {

    override fun isEmpty(): Boolean

    override val size: Int

    override fun contains(element: @UnsafeVariance E): Boolean

    fun first(): E

    fun firstOrNull(): E?

    fun joinToString(separator: String = ", ", transformer: (E) -> String = { it.toString() }): String

    override fun iterator(): Iterator<E>
}