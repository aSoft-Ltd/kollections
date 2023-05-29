package kollections.internal

internal class DoublyLinkedNode<E>(
    val element: E,
    var prev: DoublyLinkedNode<E>? = null,
    var next: DoublyLinkedNode<E>? = null
) {
    override fun toString() = "Node(prev=${prev?.element},element=$element,next=${next?.element})"
}