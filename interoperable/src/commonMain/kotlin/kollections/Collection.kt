@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kotlin.collections.Collection as KCollection
import kotlin.js.JsExport

interface Collection<out E> : Iterable<E>, KCollection<E> {

    override fun isEmpty(): Boolean

    override val size: Int

    override fun contains(element: @UnsafeVariance E): Boolean

    fun forEach(lambda: (item: E) -> Unit)

    fun forEachWithIndex(lambda: (item: E, index: Int) -> Unit)

    fun <R> map(transform: (item: E) -> R): List<R>

    fun <R> mapToArray(transform: (item: E) -> R): Array<R>

    fun <R> mapToArrayWithIndex(transform: (item: E, index: Int) -> R): Array<R>

    fun <R> mapWithIndex(transform: (item: E, index: Int) -> R): List<R>

    fun <K2, V2> associate(transformer: (E) -> MapEntry<K2, V2>): Map<K2, V2>

    fun first(): E

    fun firstOrNull(): E?
}