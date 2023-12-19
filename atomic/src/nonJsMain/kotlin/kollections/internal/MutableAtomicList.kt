package kollections.internal

import kotlinx.atomicfu.atomic
import kotlin.collections.MutableList as KMutableList

@PublishedApi
internal class MutableAtomicList<E>(
    value: KMutableList<E>
) : AbstractCollection<E>(), KMutableList<E> {

    private val atomic = atomic(value)

    override val size: Int get() = atomic.value.size

    private fun <R> doAction(block: (KMutableList<E>) -> R): R {
        val list = atomic.value.toMutableList()
        val res = block(list)
        atomic.lazySet(list)
        return res
    }

    override fun get(index: Int): E = atomic.value[index]

    override fun indexOf(element: E): Int = atomic.value.indexOf(element)

    override fun lastIndexOf(element: E): Int = atomic.value.lastIndexOf(element)

    override fun listIterator(): MutableListIterator<E> = atomic.value.listIterator()

    override fun listIterator(index: Int): MutableListIterator<E> = atomic.value.listIterator(index)

    override fun set(index: Int, element: E): E = doAction { it.set(index, element) }

    override fun subList(fromIndex: Int, toIndex: Int): KMutableList<E> = atomic.value.subList(fromIndex, toIndex)

    override fun add(index: Int, element: E) = doAction { it.add(index, element) }

    override fun addAll(index: Int, elements: Collection<E>): Boolean = doAction { it.addAll(index, elements) }

    override fun removeAt(index: Int): E = doAction { it.removeAt(index) }

    override fun clear() = atomic.lazySet(mutableListOf())

    override fun contains(element: E): Boolean = atomic.value.contains(element)

    override fun containsAll(elements: Collection<E>): Boolean = atomic.value.containsAll(elements)

    override fun isEmpty(): Boolean = atomic.value.isEmpty()

    override fun iterator(): MutableIterator<E> = atomic.value.iterator()

    override fun add(element: E): Boolean = doAction { it.add(element) }

    override fun addAll(elements: Collection<E>): Boolean = doAction { it.addAll(elements) }

    override fun remove(element: E): Boolean = doAction { it.remove(element) }

    override fun removeAll(elements: Collection<E>): Boolean = doAction { it.removeAll(elements) }

    override fun retainAll(elements: Collection<E>): Boolean = doAction { it.retainAll(elements) }
}