package kollections.internal

import kotlinx.atomicfu.AtomicRef
import kotlinx.atomicfu.atomic
import kotlin.collections.Collection as KCollection
import kotlin.collections.MutableList as KMutableList
import kollections.MutableList
import kollections.toIMutableList

internal class MutableAtomicList<E>(
    private val atomic: AtomicRef<KMutableList<E>>
) : AbstractCollection<E>(), MutableList<E> {
    constructor(list: KMutableList<E>) : this(atomic(list))

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

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> = atomic.value.subList(fromIndex, toIndex).toIMutableList()

    override fun add(index: Int, element: E) = doAction { it.add(index, element) }

    override fun addAll(index: Int, elements: KCollection<E>): Boolean = doAction { it.addAll(index, elements) }

    override fun removeAt(index: Int): E = doAction { it.removeAt(index) }

    override fun clear() = atomic.lazySet(mutableListOf())

    override fun contains(element: E): Boolean = atomic.value.contains(element)

    override fun containsAll(elements: KCollection<E>): Boolean = atomic.value.containsAll(elements)

    override fun isEmpty(): Boolean = atomic.value.isEmpty()

    override fun iterator(): MutableIterator<E> = atomic.value.iterator()

    override fun add(element: E): Boolean = doAction { it.add(element) }

    override fun addAll(elements: KCollection<E>): Boolean = doAction { it.addAll(elements) }

    override fun remove(element: E): Boolean = doAction { it.remove(element) }

    override fun removeAll(elements: KCollection<E>): Boolean = doAction { it.removeAll(elements) }

    override fun retainAll(elements: KCollection<E>): Boolean = doAction { it.retainAll(elements) }
}