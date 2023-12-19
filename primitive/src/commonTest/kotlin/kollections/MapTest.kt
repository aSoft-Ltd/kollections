package kollections

import kommander.expect
import kotlin.test.Test

class MapTest {
    @Test
    fun should_be_able_to_create_an_empty_map() {
        val map = mapOf<Int,Int>()
        expect(map.size).toBe(0)
    }

    @Test
    fun should_be_able_to_create_an_empty_mutable_map() {
        val map = mutableMapOf<Int,Int>()
        expect(map.size).toBe(0)
    }

    @Test
    fun should_be_able_to_create_a_map_with_items() {
        val map = mapOf(
            "one" to 1,
            "two" to 2,
        )
        expect(map.size).toBe(2)
    }

    @Test
    fun should_be_able_to_create_a_mutable_map_with_items() {
        val map = mutableMapOf(
            "one" to 1,
            "two" to 2,
        )
        expect(map.size).toBe(2)
    }

    @Test
    fun should_be_able_to_get_the_values_of_a_map() {
        val map = mutableMapOf(
            "one" to 1,
            "two" to 2,
        )

        println("map.size: ${map.size}")
        println("map.keys: ${map.keys}")
//        val keys = map.values
//        val values = map.values

//        values.forEach {
//            println("Value: $it")
//        }
    }
}