package kollections.internal

import kotlinx.atomicfu.atomic

@PublishedApi
internal class MutableAtomicMap<K, V>(
    value: MutableMap<K, V> = mutableMapOf()
) : MutableMap<K, V> {
    private val atomic = atomic(value)

    override val entries get() = atomic.value.entries
    override val keys get() = atomic.value.keys
    override val values get() = atomic.value.values
    override val size get() = atomic.value.size

    override fun containsKey(key: K): Boolean = atomic.value.containsKey(key)

    override fun containsValue(value: V): Boolean = atomic.value.containsValue(value)

    override fun get(key: K): V? = atomic.value[key]

    override fun isEmpty(): Boolean = atomic.value.isEmpty()


    override fun clear() = atomic.lazySet(mutableMapOf())

    private inline fun <R> doAction(builder: MutableMap<K, V>.() -> R): R {
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