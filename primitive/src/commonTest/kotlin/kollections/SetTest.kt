package kollections

import kommander.expect
import kotlin.test.Test

class SetTest {
    @Test
    fun should_be_able_to_create_an_empty_set() {
        val set = setOf<Int>()
        expect(set.size).toBe(0)
    }

    @Test
    fun should_be_able_to_add_items_to_a_set() {
        val set = mutableSetOf<Int>()
        repeat(10) { set.add(it) }
        expect(set.size).toBe(10)
    }

    @Test
    fun should_be_able_to_create_a_set_with_items() {
        val set1 = setOf(1, 2, 3, 4)
        expect(set1.size).toBe(4)

        val set2 = mutableSetOf(1, 2, 3, 4)
        expect(set2.size).toBe(4)
    }

    @Test
    fun should_be_able_to_iterate_a_set() {
        for (num in setOf(1, 2, 3, 4)) {
            println(num)
        }
    }

    @Test
    fun should_print_pretty() {
        println(setOf(1, 2, 3, 4, 5))
    }

    @Test
    fun can_get_the_iterator_out() {
        val set = setOf(1,2,3,4,5)
        val iterator = set.iterator()
        while(iterator.hasNext()) {
            val item = iterator.next()
            println(item)
        }
    }

    @Test
    fun can_convert_a_set_into_a_list() {
        val set = setOf(1,2,3,4,5)
        val list = set.toList()

        expect(set.size).toBe(5)
        expect(list.size).toBe(5)
    }
}