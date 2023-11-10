package kollections

import kommander.expect
import kotlin.test.Test

class FlockTest {
    @Test
    fun should_be_able_to_create_an_empty_flock() {
        val flock = flockOf<Int>()
        expect(flock.size).toBe(0)
    }

    @Test
    fun should_be_able_to_add_items_to_a_flock() {
        val flock = mutableFlockOf<Int>()
        repeat(10) { flock.add(10) }
        expect(flock.size).toBe(10)
    }

    @Test
    fun should_be_able_to_create_a_flock_with_items() {
        val flock1 = flockOf(1, 2, 3, 4)
        expect(flock1.size).toBe(4)

        val flock2 = mutableFlockOf(1, 2, 3, 4)
        expect(flock2.size).toBe(4)
    }

    @Test
    fun should_be_able_to_iterate_a_flock() {
        for (num in flockOf(1, 2, 3, 4)) {
            println(num)
        }
    }

    @Test
    fun should_print_preatyilly() {
        println(flockOf(1, 2, 3, 4, 5))
    }

    @Test
    fun can_get_the_iterator_out() {
        val flock = flockOf(1,2,3,4,5)
        val iterator = flock.iterator()
        while(iterator.hasNext()) {
            val item = iterator.next()
            println(item)
        }
    }
}