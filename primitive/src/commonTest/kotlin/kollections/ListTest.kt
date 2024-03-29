package kollections

import kommander.expect
import kotlin.math.exp
import kotlin.test.Test

class ListTest {
    @Test
    fun should_be_able_to_create_an_empty_list() {
        val list = listOf<Int>()
        expect(list.size).toBe(0)
    }

    @Test
    fun should_be_able_to_add_items_to_a_list() {
        val list = mutableListOf<Int>()
        repeat(10) { list.add(10) }
        expect(list.size).toBe(10)
    }

    @Test
    fun should_be_able_to_create_a_list_with_items() {
        val list1 = listOf(1, 2, 3, 4)
        expect(list1.size).toBe(4)

        val list2 = mutableListOf(1, 2, 3, 4)
        expect(list2.size).toBe(4)
    }

    @Test
    fun should_be_able_to_iterate_a_list() {
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
        val list = listOf(1, 2, 3, 4, 5)
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            println(item)
        }
    }

    @Test
    fun should_be_able_to_loop_through_a_mutable_list() {
        mutableListOf("A", "B", "C", "D").forEach {
            println(it)
        }
    }

    @Test
    fun should_be_able_to_loop_through_an_empty_mutable_list() {
        println("Empty one")
        mutableListOf<String>().forEach {
            println(it)
        }
    }

    @Test
    fun should_convert_a_list_into_a_set() {
        var count = 0
        val list = listOf(4, 5, 2, 5, 7, 8, 9).filter { it < 6 }.toSet()
        list.forEach { count += it }
        expect(count).toBe(4 + 5 + 2)
    }

    @Test
    fun should_be_able_to_find_a_specific_predicate() {
        val list = listOf("A", "B", "C", "D")
        expect(list.any { it == "A" }).toBe(true)
    }

    @Test
    fun should_map_list() {
        val list = listOf("ASSS", "BD", "CEE", "D")
        val newList = list.map { it.length }
        expect(newList.size).toBe(4)
    }

    @Test
    fun should_be_able_to_remove_an_item_from_a_list() {
        val list = mutableListOf("John", "Jane", "Jack", "Jill")
        expect(list.size).toBe(4)
        list.remove("Jane")
        expect(list.size).toBe(3)
    }

    @Test
    fun should_be_able_to_get_a_sub_list() {
        val list = mutableListOf("John", "Jane", "Jack", "Jill")
        val sub = list.subList(0, 3)
        expect(sub.size).toBe(3)
    }

    @Test
    fun should_be_able_to_retain_all_items_from_a_list() {
        val list = mutableListOf("John", "Jane", "Jack", "Jill")
        list.retainAll(listOf("Jane", "Jack"))
        list.forEach {
            println(it)
        }
        expect(list.size).toBe(2)
    }
}