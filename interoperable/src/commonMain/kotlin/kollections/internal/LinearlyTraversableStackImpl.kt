package kollections.internal

import kollections.LinearlyTraversableStack
import kollections.List
import kollections.toIList
import kotlin.math.max
import kotlin.math.min

@PublishedApi
internal class LinearlyTraversableStackImpl<E> : AbstractCollection<E>(), LinearlyTraversableStack<E> {
    private var cursor = 0
    private val list = mutableListOf<E>()

    override fun top(): E? = list.lastOrNull()

    override val size: Int get() = list.size

    override fun toList(): List<E> = list.toIList()

    override fun containsAll(elements: Collection<E>): Boolean = list.containsAll(elements)

    override fun push(element: E) {
        list.add(element)
    }

    override fun current(): E? = list.getOrNull(cursor)

    override fun pop(): E? = list.removeLastOrNull()

    override fun canPop(): Boolean = list.isNotEmpty()

    override fun isEmpty(): Boolean = list.isEmpty()

    override fun insertTrimmingTop(element: E) {
        insert(element)
        list.retainAll(list.subList(0, cursor + 1))
    }

    override fun insertTrimmingBottom(element: E) {
        insert(element)
        list.retainAll(list.subList(cursor, list.size))
        cursor = list.indexOf(element)
    }

    override fun insert(element: E) {
        cursor = min(cursor + 1, list.size)
        list.add(cursor, element)
    }

    override fun contains(element: E): Boolean = list.contains(element)

    override fun iterator() = list.iterator()

    override fun forward(): E? {
        if (cursor + 1 >= size) return null
        return list[++cursor]
    }

    override fun back(): E? {
        if (cursor <= 0) return null
        return list[--cursor]
    }

    override fun go(steps: Int): E? {
        when {
            steps > 0 -> repeat(steps) { cursor = min(cursor + 1, size - 1) }
            steps < 0 -> repeat(-steps) { cursor = max(0, cursor - 1) }
            else -> return list.firstOrNull()
        }
        return list.getOrNull(cursor)
    }

    override fun toString() = buildString {
        append("[")
        val end = list.size - 1
        for (i in list.indices) {
            val el = list[i]
            if (i == cursor) append("{$el}") else append(el)
            if (i != end) append(",")
        }
        append("]")
    }
}