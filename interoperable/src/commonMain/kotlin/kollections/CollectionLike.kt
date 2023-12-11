@file:JsExport

package kollections

import kotlin.collections.Collection as KCollection
import kotlinx.JsExport

interface CollectionLike<out E> : Iterable<E>, KCollection<E> {

    override fun isEmpty(): Boolean

    override val size: Int

    override fun contains(element: @UnsafeVariance E): Boolean

    fun first(): E

    fun firstOrNull(): E?

    fun joinToString(separator: String = ", ", transformer: (E) -> String = { it.toString() }): String

    override fun iterator(): Iterator<E>

//    override fun spliterator() : Spliterator<E>
}