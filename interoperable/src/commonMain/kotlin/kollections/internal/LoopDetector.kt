package kollections.internal

import kollections.toISet

internal class LoopDetector<N, E>(val graph: DirectedGraphImpl<N, E>) {

    fun loops(): List<Set<N>> {
        val res = mutableListOf(setOf<N>())
        for (node in graph.nodes.keys) {
            val r = paths(node, node, mutableSetOf())
            if (r.isNotEmpty()) res.addAll(r)
        }
        return res
    }

    class Trail<out N>(
        val node: N,
        val paths: List<N>,
        val index: Int = 0
    )

    private fun paths(from: N, to: N, visited: MutableSet<N>): List<Set<N>> {
        val queue = Queue(Trail(from, emptyList(), 0))
        visited.add(from)
        while (queue.size > 0) {
            val item = queue.shift() ?: return emptyList()
            val node = item.node
            val distance = item.index

            if (from == to) return listOf(item.paths.toISet())

            for (neighbour in graph.nodes[node]?.keys ?: emptySet()) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour)
                    queue.add(Trail(neighbour, item.paths + neighbour, distance + 1))
                }
            }
        }

        return emptyList()
    }
}