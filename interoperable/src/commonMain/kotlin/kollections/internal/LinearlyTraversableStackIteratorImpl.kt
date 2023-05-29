package kollections.internal

@PublishedApi
internal class LinearlyTraversableStackIteratorImpl<E>(
    stack: LinearlyTraversableStackImpl<E>
) : Iterator<E> {
    private var next = stack.head

    override fun hasNext(): Boolean = next != null

    override fun next(): E {
        val element = next?.element!!
        next = next?.next
        return element
    }
}