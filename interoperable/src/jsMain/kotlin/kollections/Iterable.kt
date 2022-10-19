@file:JsExport

package kollections

import kotlin.collections.Collection as KCollection1
import kotlin.collections.Iterable as KIterable
import kotlin.collections.Map as KMap

actual interface Iterable<out E> : KIterable<E> {
    fun toArray(): Array<out E> {
        val size = count()
        val array: Array<in Any?> = Array(size) { null }
        forEachIndexed { index, e -> array[index] = e }
        return array as Array<out E>
    }

    private fun count() = when (this) {
        is KCollection1<*> -> size
        is KMap<*, *> -> size
        else -> {
            var size = 0
            for (item in this) size++
            size
        }
    }
}