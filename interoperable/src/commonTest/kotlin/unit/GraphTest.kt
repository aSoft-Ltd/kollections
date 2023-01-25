package unit

import expect.expect
import kollections.graphOf
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
}