package unit

import kommander.expect
import kommander.expectCollection
import kollections.iEmptyList
import kotlin.test.Test

class ListTest {
    @Test
    fun should_be_instantiatable() {
        val list = listOf(1, 2, 3, 4, 5)
        println(list)
        expectCollection(list).toContain(2, 3, 4)
    }

    @Test
    fun mutable_lists_should_be_like_lists() {
        val mutableList = mutableListOf(1, 2, 3, 4, 5, 6, 7)
        println(mutableList)
        expectCollection(mutableList).toContain(2, 5, 7)
    }

    @Test
    fun empty_list_prints_correctly() {
        val emptyList = iEmptyList<Boolean>()
        println(emptyList)
        expect(emptyList.isEmpty()).toBe(true)
    }
}