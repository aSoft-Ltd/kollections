package kollections.internal

import kotlin.collections.associate as kAssociate
import kotlin.collections.first as kFirst
import kotlin.collections.firstOrNull as kFirstOrNull
import kotlin.collections.forEach as kForEach
import kotlin.collections.forEachIndexed as kForEachIndexed
import kotlin.collections.map as kMap
import kotlin.collections.mapIndexed as kMapIndex
import kollections.Collection
import kollections.List
import kollections.Map
import kollections.MapEntry
import kollections.toIList
import kollections.toIMap
import kotlin.collections.mapIndexed

abstract class AbstractCollection<E> : AbstractIterable<E>(), Collection<E> {

    override fun forEach(lambda: (item: E) -> Unit) = kForEach(lambda)

    override fun forEachWithIndex(lambda: (item: E, index: Int) -> Unit) = kForEachIndexed { index, item -> lambda(item, index) }

    override fun <R> map(transform: (item: E) -> R): List<R> = kMap(transform).toIList()

    override fun <R> mapToArray(transform: (item: E) -> R): Array<R> {
        val array: Array<in Any?> = Array(size) { null }
        forEachWithIndex { e, index -> array[index] = transform(e) }
        return array as Array<R>
    }

    override fun <R> mapToArrayWithIndex(transform: (item: E, index: Int) -> R): Array<R> {
        val array: Array<in Any?> = Array(size) { null }
        forEachWithIndex { e, index -> array[index] = transform(e, index) }
        return array as Array<R>
    }

    override fun <R> mapWithIndex(transform: (item: E, index: Int) -> R): List<R> = kMapIndex { index, e -> transform(e, index) }.toIList()

    override fun <K, V> associate(transformer: (E) -> MapEntry<K, V>): Map<K, V> {
        return kAssociate { transformer(it).toPair() }.toIMap()
    }

    override fun first(): E = kFirst()

    override fun firstOrNull(): E? = kFirstOrNull()
}