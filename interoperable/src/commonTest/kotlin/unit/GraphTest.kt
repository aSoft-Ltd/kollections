package unit

import expect.expect
import kollections.buildDirectedGraph
import kollections.graphOf
import kollections.directedGraphOf
import kotlin.test.Test

class GraphTest {
    @Test
    fun should_be_able_to_instantiate_an_empty_graph() {
        val g = graphOf<Int, Int>()
        expect(g.isEmpty()).toBe(true)
    }

    @Test
    fun should_be_able_to_instantiate_with_pre_filed_nodes() {
        val g = graphOf<Int, Int>(1, 2, 3, 4, 5)
        expect(g.isEmpty()).toBe(false)
        expect(g.size).toBe(5)
    }

    @Test
    fun should_be_able_to_nodes_and_edges() {
        /*
              (A)- - (B)
               |     /
               |    /
               |  (C)
               |  / \
               | /   \
              (D)- - (E)
        */
        val g = directedGraphOf<Char, Char>()
        g.add('A')
        g.add('B')
        g.add('C')
        g.add('D')
        g.add('E')
        g.connect('A', 'B', '-')
        g.connect('B', 'C', '/')
        g.connect('C', 'D', '/')
        g.connect('C', 'E', '\\')
        g.connect('E', 'D', '-')
        g.connect('D', 'A', '|')
        expect(g.isConnected('A', 'B')).toBe(true)
        expect(g.edge('A', 'B')).toBe('-')

        expect(g.isConnected('C', 'D')).toBe(true)
        expect(g.edge('C', 'D')).toBe('/')
    }

    /*
                      (A)
                     /   \
                   (C) - (B)
     */
    val abcGraph = buildDirectedGraph('A', 'B', 'C') {
        connect('A', 'B', '\\')
        connect('B', 'C', '-')
        connect('C', 'A', '/')
    }

    @Test
    fun should_be_able_to_check_path_possibility() {
        expect(abcGraph.hasPath('A', 'B')).toBe(true)
        expect(abcGraph.hasPath('A', 'C')).toBe(true)
        expect(abcGraph.hasPath('B', 'C')).toBe(true)
    }

    @Test
    fun should_be_able_to_find_possible_paths() {
        val g = abcGraph
        expect(g.paths('A', 'B').size).toBe(1)
    }

    @Test
    fun should_be_able_to_detect_a_simple_loop() {
        val g = abcGraph
        val loops = g.loops()
        println("Loops: $loops")
        expect(loops.size).toBe(3)
        val loop = loops.first()
        expect(loop).toBe(setOf('A', 'B', 'C'))
    }
}