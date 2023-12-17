package kollections

import kommander.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class SetSerializationTest {

    private val codec = Json {  }

    private interface Preserve {
        val contents: Set<String>
    }
    @Serializable
    private data class Zoo(override val contents: Set<String>) : Preserve
    @Serializable
    private data class MutableZoo(override val contents: MutableSet<String>) : Preserve

    @Test
    fun should_be_able_to_serialize_a_mutable_set() {
        val animals = MutableZoo(mutableSetOf("Lion","Tiger"))
        expect(codec.encodeToString(animals)).toBe("""{"contents":["Lion","Tiger"]}""")
    }

    @Test
    fun should_be_able_to_serialize_a_set() {
        val animals = Zoo(setOf("Lion","Tiger"))
        expect(codec.encodeToString(animals)).toBe("""{"contents":["Lion","Tiger"]}""")
    }
}