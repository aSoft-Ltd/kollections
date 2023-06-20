@file:JsExport

package kollections

import kotlin.collections.Collection as KCollection
import kotlin.js.JsExport

interface CollectionLike<out E> : Iterable<E>, KCollection<E> {

    override fun isEmpty(): Boolean

    override val size: Int

    override fun contains(element: @UnsafeVariance E): Boolean

    fun first(): E

    fun firstOrNull(): E?

    fun joinToString(separator: String = ", ", transformer: (E) -> String = { it.toString() }): String
}