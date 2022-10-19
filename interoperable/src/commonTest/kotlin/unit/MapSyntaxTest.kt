package unit

import kollections.iMapOf
import kollections.pairOf
import kotlin.test.Test

class MapSyntaxTest {
    @Test
    fun can_map_keys_to_other_keys() {
        val numbers = iMapOf(pairOf(1, "One"))
        numbers.map { (key, value) ->
            println("{$key: $value}")
        }
    }
}