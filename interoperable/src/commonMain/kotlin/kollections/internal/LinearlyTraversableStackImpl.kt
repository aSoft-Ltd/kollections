package kollections.internal

import kollections.LinearlyTraversableStack
import kollections.List
import kollections.toIList

@PublishedApi
internal class LinearlyTraversableStackImpl<E> : AbstractCollection<E>(), LinearlyTraversableStack<E> {
    internal var head: DoublyLinkedNode<E>? = null
    private var cursor = head
    override var size: Int = 0

    override fun top(): E? = head?.element

    override fun toList(): List<E> = toKList().toIList()

    private fun toKList() = iterator().asSequence().toList()

    override fun containsAll(elements: Collection<E>): Boolean = toKList().containsAll(elements)

    override fun push(element: E) {
        val newHead = DoublyLinkedNode(element)
        val oldHead = head
        if (oldHead != null) {
            newHead.next = oldHead
            oldHead.prev = newHead
        }
        head = newHead
        size++
    }

    override fun pop(): E? {
        val element = head?.element
        head = head?.next
        size--
        return element
    }

    override fun canPop(): Boolean = head != null

    override fun isEmpty(): Boolean = size == 0

    override fun contains(element: E): Boolean = toKList().contains(element)

    override fun iterator() = LinearlyTraversableStackIteratorImpl(this)

    override fun forward(): E? {
        val crsr = cursor ?: head
        val prev = crsr?.prev
        val el = prev?.element
        cursor = prev
        return el
    }

    override fun back(): E? {
        val crsr = cursor ?: head
        val next = crsr?.next
        val el = next?.element
        cursor = next
        return el
    }

    override fun go(steps: Int): E? {
        val crsr = cursor ?: head
        var el: E?
        when {
            steps > 0 -> {
                var count = 0
                do {
                    el = forward()
                    count++
                } while (steps - count > 0 && el != null)
            }

            steps < 0 -> {
                var count = 0
                do {
                    el = back()
                    count++
                } while (steps + count < 0 && el != null)
            }

            else -> el = crsr?.element
        }
        return el
    }
}