@file:JsExport

package kollections

import kotlin.js.JsExport
import kotlin.collections.associate as kAssociate
import kotlin.collections.Collection as KCollection
import kotlin.collections.first as kFirst
import kotlin.collections.firstOrNull as kFirstOrNUll

interface Collection<out E> : Iterable<E>, KCollection<E> {

    override fun isEmpty(): Boolean

    override val size: Int

    override fun contains(element: @UnsafeVariance E): Boolean

    fun forEach(lambda: (item: E) -> Unit) {
        for (item in this) lambda(item)
    }

    fun forEachWithIndex(lambda: (item: E, index: Int) -> Unit) {
        for (item in this) lambda(item, indexOf(item))
    }

    fun <O> map(transform: (item: E) -> O): List<O> {
        val l = iMutableListOf<O>()
        for (item in this) l.add(transform(item))
        return l
    }

    fun <O> mapToArray(transform: (item: E) -> O): Array<out O> {
        val array: Array<in Any?> = Array(size) { null }
        forEachWithIndex { e, index -> array[index] = transform(e) }
        return array as Array<out O>
    }

    fun <O> mapToArrayWithIndex(transform: (item: E, index: Int) -> O): Array<out O> {
        val array: Array<in Any?> = Array(size) { null }
        forEachWithIndex { e, index -> array[index] = transform(e, index) }
        return array as Array<out O>
    }

    fun <O> mapWithIndex(transform: (item: E, index: Int) -> O): List<O> {
        val l = iMutableListOf<O>()
        for (item in this) l.add(transform(item, indexOf(item)))
        return l
    }

    fun <K, V> associate(transformer: (E) -> MapEntry<K, V>): Map<K, V> {
        return this.kAssociate { transformer(it).toPair() }.toIMap()
    }

    fun first() : E = kFirst()

    fun firstOrNull() : E? = kFirstOrNUll()
}