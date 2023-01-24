package kollections.internal

import kotlinx.atomicfu.atomic
import kollections.MutableMap
import kotlin.collections.MutableMap as KMutableMap
import kollections.MapEntry
import kollections.Set
import kollections.to
import kollections.toIMutableList
import kollections.toIMutableSet
import kollections.toISet

internal class MutableAtomicMap<K, V>(
    value: KMutableMap<K, V> = mutableMapOf()
) : AbstractCollection<MapEntry<K, V>>(), MutableMap<K, V> {
    private val atomic = atomic(value)

    override val entries get() = atomic.value.entries
    override val keys get() = atomic.value.keys.toIMutableSet()
    override val values get() = atomic.value.values.toIMutableList()
    override val size get() = atomic.value.size

    override fun containsKey(key: K): Boolean = atomic.value.containsKey(key)

    override fun containsValue(value: V): Boolean = atomic.value.containsValue(value)

    override fun get(key: K): V? = atomic.value[key]

    override fun isEmpty(): Boolean = atomic.value.isEmpty()

    override fun contains(element: MapEntry<K, V>): Boolean = get(element.key) == element.value

    override fun iterator(): Iterator<MapEntry<K, V>> = entries.map { it.key to it.value }.iterator()

    override fun containsAll(elements: Collection<MapEntry<K, V>>): Boolean = entries.containsAll(entries)

    override fun clear() = atomic.lazySet(mutableMapOf())

    override fun set(key: K, value: V) {
        put(key, value)
    }

    override val pairs: Set<MapEntry<K, V>> = entries.map { it.key to it.value }.toISet()

    override fun getValue(key: K): V = atomic.value.getValue(key)

    private inline fun <R> doAction(builder: KMutableMap<K, V>.() -> R): R {
        val map = atomic.value
        val newMap = mutableMapOf<K, V>().apply { putAll(map) }
        val res = newMap.builder()
        atomic.lazySet(newMap)
        return res
    }

    override fun put(key: K, value: V): V? = doAction { put(key, value) }

    override fun putAll(from: Map<out K, V>) = doAction { putAll(from) }

    override fun remove(key: K): V? = doAction { remove(key) }
}