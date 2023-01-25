package kollections.internal

import kollections.MutableGraph

internal class MutableGraphImpl<N, E>(
    private val nodes: MutableMap<N, MutableList<N>> = mutableMapOf()
) : AbstractCollection<N>(), MutableGraph<N, E> {

    constructor(vararg nodes: N) : this(nodes.associateWith { mutableListOf<N>() }.toMutableMap())

    override fun add(element: N): Boolean {
        nodes[element] = mutableListOf()
        return true
    }

    override fun remove(element: N): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override val size: Int get() = nodes.size

    override fun addAll(elements: Collection<N>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean = nodes.isEmpty()

    override fun iterator(): MutableIterator<N> {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<N>): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<N>): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<N>): Boolean {
        TODO("Not yet implemented")
    }

    override fun contains(element: N): Boolean {
        TODO("Not yet implemented")
    }

}
