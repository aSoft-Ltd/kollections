package kollections.internal

import kollections.MutableSet
import kollections.toIMutableSet
import kollections.toIMutableList
import kollections.MutableCollection
import kollections.MutableMap
import kollections.MapEntry
import kollections.toISet
import kollections.Set
import kotlin.collections.Collection
import kotlin.collections.MutableMap as KMutableMap

@PublishedApi
internal open class MutableMapWrapper<K, V>(private val map: KMutableMap<K, V>) : MutableMap<K, V>, KMutableMap<K, V> by map {

    override val keys: MutableSet<K> get() = map.keys.toIMutableSet()

    override val size: Int get() = map.size

    override val pairs: Set<MapEntry<K, V>> get() = map.entries.map { MapEntryImpl(it.key, it.value) }.toISet()

    override val values: MutableCollection<V> = map.values.toIMutableList()

    override fun contains(element: MapEntry<K, V>): Boolean = pairs.contains(element)

    override fun containsAll(elements: Collection<MapEntry<K, V>>): Boolean = pairs.containsAll(elements)

    override fun iterator(): Iterator<MapEntry<K, V>> = pairs.iterator()

    override fun toString(): String = map.toString()

    override fun hashCode(): Int = map.hashCode()

    override fun equals(other: Any?): Boolean = map == other
}