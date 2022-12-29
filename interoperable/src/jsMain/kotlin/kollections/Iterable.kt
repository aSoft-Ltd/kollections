@file:JsExport

package kollections

import kotlin.collections.Iterable as KIterable

actual interface Iterable<out E> : KIterable<E> {
    fun toArray(): Array<out E>

    fun count() : Int
}