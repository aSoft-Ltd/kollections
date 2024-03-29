package kollections

import kommander.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class ListSerializationTest {

    private val codec = Json {  }

    private interface Preserve {
        val contents: List<String>
    }
    @Serializable
    private data class Zoo(override val contents: List<String>) : Preserve
    @Serializable
    private data class MutableZoo(override val contents: MutableList<String>) : Preserve

    @Test
    fun should_be_able_to_serialize_a_mutable_list() {
        val animals = MutableZoo(mutableListOf("Lion","Tiger"))
        expect(codec.encodeToString(animals)).toBe("""{"contents":["Lion","Tiger"]}""")
    }

    @Test
    fun should_be_able_to_serialize_a_list() {
        val animals = Zoo(listOf("Lion","Tiger"))
        expect(codec.encodeToString(animals)).toBe("""{"contents":["Lion","Tiger"]}""")
    }
}