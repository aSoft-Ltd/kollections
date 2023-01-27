package kollections.internal

import kollections.List
import kollections.MutableGraph
import kollections.Set
import kollections.toIList
import kollections.toISet

internal abstract class AbstractGraph<N, E>(
    val nodes: MutableMap<N, MutableMap<N, E>> = mutableMapOf()
) : AbstractCollection<N>(), MutableGraph<N, E> {

    override fun add(element: N): Boolean {
        nodes[element] = mutableMapOf()
        return true
    }

    override fun edge(from: N, to: N): E? = nodes[from]?.get(to)

    override fun isConnected(node1: N, node2: N): Boolean = edge(node1, node2) != null

    override fun remove(element: N): Boolean = nodes.remove(element) != null

    override fun clear() = nodes.clear()

    override fun loops(): List<Set<N>> {
        val result = mutableListOf<List<N>>()
        val visited = mutableSetOf<N>()
        nodes.keys.forEach { start ->
            dfs(start, start, visited, mutableListOf(start), result)
        }
        return result.map { it.toISet() }.toIList()
    }

    override fun uniqueLoops(): List<Set<N>> {
        val ls = loops()
        val res = mutableListOf<Set<N>>()
        for (l in ls) {
            for (r in res) {
                if (r.containsAll(l)) continue else res.add(l)
            }
        }
        return res.map { it.toISet() }.toIList()
    }

    private fun dfs(current: N, start: N, visited: MutableSet<N>, path: MutableList<N>, result: MutableList<List<N>>) {
        visited.add(current)
        nodes[current]?.keys?.forEach { neighbor ->
            if (neighbor == start) {
                result.add(path.toIList())
            } else if (!visited.contains(neighbor)) {
                path.add(neighbor)
                dfs(neighbor, start, visited, path, result)
                path.remove(path.last())
            }
        }
        visited.remove(current)
    }

    override fun hasPath(from: N, to: N): Boolean = hasPathImpl(from, to, mutableSetOf())

    private fun hasPathImpl(from: N, to: N, visited: MutableSet<N>): Boolean {
        if (from == to) return true
        if (visited.contains(from)) return false
        visited.add(from)
        for (neighbour in nodes[from]?.keys ?: emptySet()) {
            if (hasPathImpl(neighbour, to, visited)) return true
        }
        return false
    }

    override fun paths(from: N, to: N): List<Set<N>> = findPaths(from, to)

    fun findPaths(start: N, destination: N): List<Set<N>> {
        val result = mutableListOf<List<N>>()
        val path = mutableListOf(start)
        val visited = mutableSetOf(start)
        dfs(start, destination, visited, path, result)
        return result.map { it.toISet() }.toIList()
    }

    override val size: Int get() = nodes.size

    override fun addAll(elements: Collection<N>): Boolean {
        for (el in elements) add(el)
        return true
    }

    override fun isEmpty(): Boolean = nodes.isEmpty()

    override fun iterator(): MutableIterator<N> = nodes.keys.iterator()

    override fun retainAll(elements: Collection<N>): Boolean = nodes.keys.retainAll(elements)

    override fun removeAll(elements: Collection<N>): Boolean = nodes.keys.removeAll(elements)

    override fun containsAll(elements: Collection<N>): Boolean = nodes.keys.containsAll(elements)

    override fun contains(element: N): Boolean = nodes.keys.contains(element)
}