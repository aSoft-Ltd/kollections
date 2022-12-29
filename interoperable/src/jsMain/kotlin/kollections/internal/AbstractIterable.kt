package kollections.internal

import kollections.Iterable
import kotlin.collections.count as kCount

actual abstract class AbstractIterable<out E> : Iterable<E> {

    override fun toArray(): Array<out E> {
        val size = kCount()
        val array: Array<in Any?> = Array(size) { null }
        forEachIndexed { index, e -> array[index] = e }
        return array as Array<out E>
    }

    override fun count() = kCount()
}