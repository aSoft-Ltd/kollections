package kollections

import kommander.expect
import kotlin.test.Test

class ListTest {
    @Test
    fun should_be_able_to_create_an_empty_flock() {
        val list = listOf<Int>()
        expect(list.size).toBe(0)
    }

    @Test
    fun should_be_able_to_add_items_to_a_flock() {
        val list = mutableListOf<Int>()
        repeat(10) { list.add(10) }
        expect(list.size).toBe(10)
    }

    @Test
    fun should_be_able_to_create_a_flock_with_items() {
        val list1 = listOf(1, 2, 3, 4)
        expect(list1.size).toBe(4)

        val list2 = mutableListOf(1, 2, 3, 4)
        expect(list2.size).toBe(4)
    }

    @Test
    fun should_be_able_to_iterate_a_flock() {
        for (num in listOf(1, 2, 3, 4)) {
            println(num)
        }
    }

    @Test
    fun should_print_pretty() {
        println(listOf(1, 2, 3, 4, 5))
    }

    @Test
    fun can_get_the_iterator_out() {
        val list = listOf(1,2,3,4,5)
        val iterator = list.iterator()
        while(iterator.hasNext()) {
            val item = iterator.next()
            println(item)
        }
    }
}