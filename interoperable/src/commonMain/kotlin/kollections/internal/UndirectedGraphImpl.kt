package kollections.internal

internal class UndirectedGraphImpl<N, E>(
    nodes: MutableMap<N, MutableMap<N, E>> = mutableMapOf()
) : AbstractGraph<N, E>(nodes) {

    constructor(vararg nodes: N) : this(nodes.associateWith { mutableMapOf<N, E>() }.toMutableMap())

    override fun connect(from: N, to: N, with: E) {
        nodes[from]?.put(to, with)
        nodes[to]?.put(from, with)
    }
}
